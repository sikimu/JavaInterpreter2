package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiInstance;
import jp.co.javainterpreter.object.JiClass;
import jp.co.javainterpreter.object.JiInteger;
import jp.co.javainterpreter.object.JiObject;
import jp.co.javainterpreter.stream.SourceTokenList;
import jp.co.javainterpreter.token.Token;

import java.util.ArrayList;

public class JavaInterpreter {

    ArrayList<JiClass> classes = new ArrayList<>();

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

        JiClass jiClass;

        SourceTokenList sourceTokenList = new SourceTokenList(source);

        int position = 0;
        while (sourceTokenList.size() > position) {
            Token token = sourceTokenList.get(position);
            switch (token.type) {
                case CLASS -> {
                    String className = sourceTokenList.get(position + 1).value;
                    position += 2;
                    SourceTokenList subList = sourceTokenList.subList(position);
                    classes.add(JiClass.create(packageName, className, subList));
                    position += subList.size();
                }
                default -> throw new RuntimeException("Invalid token: " + token.type);
            }
        }
    }

    /**
     * クラスの取得
     * @param packageName パッケージ名
     * @param className クラス名
     * @return Jiクラス
     */
    public jp.co.javainterpreter.object.JiClass getJiClass(String packageName, String className) {
        for (JiClass jiClass : classes) {
            if (jiClass.packageName.equals(packageName) && jiClass.className.equals(className)) {
                return jiClass;
            }
        }
        throw new RuntimeException("Class not found: " + packageName + "." + className);
    }

    public JiObject callMethod(String className, String methodName, JiObject[] args) {

        return new JiInteger(3);
    }
}
