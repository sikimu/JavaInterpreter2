package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiInstance;
import jp.co.javainterpreter.object.JiClass;
import jp.co.javainterpreter.stream.TokenStream;
import jp.co.javainterpreter.token.Token;

public class JavaInterpreter {

    JiClass jiClass;

    public JiInstance createInstance(String className) {

        if(className.equals("jp.co.javainterpreter.instance.JiClassInstance")) {
            return new JiInstance();
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
                case CLASS -> jiClass = JiClass.create(packageName, tokenStream);
                default -> throw new RuntimeException("Invalid token: " + token.type);
            }
        }

        jiClass = new JiClass(packageName, "Token");
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
