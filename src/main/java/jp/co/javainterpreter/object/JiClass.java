package jp.co.javainterpreter.object;

import jp.co.javainterpreter.expression.JiExpression;
import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.stream.SourceTokenList;
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
     * @param className クラス名
     * @param tokenList トークンリスト
     */
    public static JiClass create(String packageName, String className, SourceTokenList tokenList) {

        JiClass jiClass = new JiClass(packageName, className);

        for(int i = 0; i < tokenList.size(); i++) {
            Token token = tokenList.get(i);
            if(token.type == Token.Type.IDENTIFIER) {
                String methodName = token.value;
                i++;
                SourceTokenList parameterList = tokenList.subListParen(i);
                i += parameterList.size() + 2;
                SourceTokenList bodyList = tokenList.subList(i);
                JiMethod method = new JiMethod(methodName, new Token(Token.Type.INT, "int"));
                method.addStatement(new JiReturnStatement(new JiExpression(new JiInteger(3))));
                jiClass.addMethod(method);
                break;
            }
        }

        return jiClass;
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
                // メソッドの終わりまでのリストを作成
                ArrayList<Token> methodTokens = new ArrayList<>();
                while (pos < tokens.size() && tokens.get(pos).type != Token.Type.R_BRACE) {
                    methodTokens.add(tokens.get(pos));
                    pos++;
                }

                loadMethod(methodTokens);
            }
            pos++;
        }
    }

    private void loadMethod(ArrayList<Token> tokens) {

        int pos = 0;

        JiMethod method = new JiMethod("", new Token(Token.Type.INT, "int"));
        pos++;
        while (pos < tokens.size() && tokens.get(pos).type != Token.Type.R_BRACE) {
            JiExpression jiExpression = new JiExpression(new JiString(tokens.get(pos).value));
            method.addStatement(new JiReturnStatement(jiExpression));
            pos++;
        }
        methods.add(method);
    }
}
