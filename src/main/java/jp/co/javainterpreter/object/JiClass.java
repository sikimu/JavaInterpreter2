package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.stream.TokenStream;
import jp.co.javainterpreter.token.Token;

import java.util.ArrayList;
import java.util.List;

public class JiClass {

    public final String packageName;
    public final String className;

    /** メソッドリスト */
    final List<JiMethod> methods = new ArrayList<>();

    /**
     * Jiクラスの作成
     * @param packageName パッケージ名
     * @param tokenStream トークンストリーム
     */
    public static JiClass create(String packageName, TokenStream tokenStream) {

        Token token = tokenStream.next();
        if(token.type != Token.Type.IDENTIFIER) {
            throw new RuntimeException("Invalid token: " + token.type);
        }

        String className = token.value;

        token = tokenStream.next();
        if(token.type != Token.Type.L_BRACE) {
            throw new RuntimeException("Invalid token: " + token.type);
        }

        while (tokenStream.hasNext()) {
            token = tokenStream.next();
            if(token.type == Token.Type.R_BRACE) {
                break;
            }
        }

        return new JiClass(packageName, className);
    }

    /**
     * Constructor
     * @param packageName パッケージ名
     * @param className クラス名
     */
    public JiClass(String packageName, String className) {

        this.packageName = packageName;
        this.className = className;
    }

    public String getFullName() {

        return "jp.co.javainterpreter.token.Token";
    }

    /**
     * メソッドの実行
     */
    public JiObject executeMethod(String methodName) {

        return getMethod(methodName).execute();
    }

    private JiMethod getMethod(String methodName) {

        for(JiMethod method : methods) {
            if(method.name.equals(methodName)) {
                return method;
            }
        }

        throw new RuntimeException("Method not found: " + methodName);
    }

    /**
     * メソッドの追加
     * @param method メソッド
     */
    public void addMethod(JiMethod method) {

        methods.add(method);
    }

    public void loadBody(ArrayList<Token> tokens) {

        int pos = 0;
        while (pos < tokens.size()) {
            // ;または{または=が出現するまでトークンを読み込む
            while (pos < tokens.size() &&
                    tokens.get(pos).type != Token.Type.SEMICOLON &&
                    tokens.get(pos).type != Token.Type.L_BRACE &&
                    tokens.get(pos).type != Token.Type.EQUAL) {
                pos++;
            }
            //{が出現したらメソッドの読み込みを開始する
            if(tokens.get(pos).type == Token.Type.L_BRACE) {
                pos = loadMethod(tokens, pos);
            }
            pos++;
        }
    }

    private int loadMethod(ArrayList<Token> tokens, int pos) {

        JiMethod method = new JiMethod(tokens.get(pos - 1).value, tokens.get(pos - 2));
        pos++;
        while (pos < tokens.size() && tokens.get(pos).type != Token.Type.R_BRACE) {
            method.addStatement(new JiReturnStatement(new JiString(tokens.get(pos).value)));
            pos++;
        }
        methods.add(method);

        return pos;
    }
}
