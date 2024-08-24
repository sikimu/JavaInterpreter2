package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiClassInstance;
import jp.co.javainterpreter.object.JiClass;
import jp.co.javainterpreter.stream.TokenStream;
import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;

public class JavaInterpreter {

    JiClass jiClass;

    public JiClassInstance createInstance(String className) {

        if(className.equals("jp.co.javainterpreter.instance.JiClassInstance")) {
            return new JiClassInstance();
        }

        throw new RuntimeException("Class not found: " + className);
    }

    /**
     * ソースの読み込み
     *
     * @param packageName パッケージ名
     * @param source ソース
     */
    public void loadSource(String packageName, String source) {

        TokenStream tokenStream = new TokenStream(source);

        while (tokenStream.hasNext()) {
            Token token = tokenStream.next();
            switch (token.type) {
                case CLASS -> jiClass = createJiClass(packageName, tokenStream);
                default -> throw new RuntimeException("Invalid token: " + token.type);
            }
        }

        jiClass = new JiClass(packageName, "Token");
    }

    /**
     * Jiクラスの作成
     * @param packageName パッケージ名
     * @param tokenStream トークンストリーム
     */
    private JiClass createJiClass(String packageName, TokenStream tokenStream) {

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

        return new JiClass("jp.co.javainterpreter.token", className);
    }

    /**
     * クラスの取得
     * @param packageName パッケージ名
     * @param className クラス名
     * @return Jiクラス
     */
    public jp.co.javainterpreter.object.JiClass getJiClass(String packageName, String className) {
        if(jiClass.packageName.equals(packageName) && jiClass.className.equals(className)) {
            return jiClass;
        }
        throw new RuntimeException("Class not found: " + packageName + "." + className);
    }
}
