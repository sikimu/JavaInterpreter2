package jp.co.javainterpreter;

public class JiClassInstance {
    public JiClassInstance(JiClass jiClass) {
    }

    public JiObject.JiInt callMethod(String methodName) {
        return new JiObject.JiInt(1);
    }
}
