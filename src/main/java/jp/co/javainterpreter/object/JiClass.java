package jp.co.javainterpreter.object;

import jp.co.javainterpreter.stream.TokenStream;
import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class JiClass {

    public final String packageName;
    public final String className;

    /** メソッドリスト */
    private final List<JiMethod> methods = new ArrayList<>();

    /**
     * Jiクラスの作成
     * @param packageName パッケージ名
     * @param tokenStream トークンストリーム
     */
    public static JiClass create(String packageName, TokenStream tokenStream) {

        Token token = tokenStream.next();
        if(token.type != TokenType.IDENTIFIER) {
            throw new RuntimeException("Invalid token: " + token.type);
        }

        String className = token.value;

        token = tokenStream.next();
        if(token.type != TokenType.L_BRACE) {
            throw new RuntimeException("Invalid token: " + token.type);
        }

        while (tokenStream.hasNext()) {
            token = tokenStream.next();
            if(token.type == TokenType.R_BRACE) {
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
}
