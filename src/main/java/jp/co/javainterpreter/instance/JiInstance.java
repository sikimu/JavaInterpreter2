package jp.co.javainterpreter.instance;

import jp.co.javainterpreter.object.JiObject;
import jp.co.javainterpreter.object.JiString;

public class JiInstance {
    private final String className;

    public JiInstance() {
        this.className = "jp.co.javainterpreter.instance.JiClassInstance";
    }

    public String getClassName() {
        return className;
    }

    public JiObject executeMethod(String methodName) {
        return new JiString("Hello, World!");
    }
}
