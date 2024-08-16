package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiClassInstance;
import jp.co.javainterpreter.object.JiClass;

public class JavaInterpreter {

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
    }

    /**
     * クラスの取得
     * @param packageName パッケージ名
     * @param className クラス名
     * @return Jiクラス
     */
    public jp.co.javainterpreter.object.JiClass getJiClass(String packageName, String className) {
        return new JiClass(packageName, className);
    }
}
