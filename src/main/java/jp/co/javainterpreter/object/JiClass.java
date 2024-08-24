package jp.co.javainterpreter.object;

import jp.co.javainterpreter.stream.TokenStream;
import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;

public class JiClass {

    public final String packageName;
    public final String className;

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
        if(token.type != TokenType.SEPARATOR || !token.value.equals("{")) {
            throw new RuntimeException("Invalid token: " + token.type);
        }

        while (tokenStream.hasNext()) {
            token = tokenStream.next();
            if(token.type == TokenType.SEPARATOR && token.value.equals("}")) {
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
}
