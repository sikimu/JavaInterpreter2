package jp.co.javainterpreter.object;

public class JiClass {

    final String packageName;
    final String className;

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
