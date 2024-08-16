package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiClassInstance;

public class JavaInterpreter {

    public JiClassInstance createInstance(String className) {

        if(className.equals("jp.co.javainterpreter.instance.JiClassInstance")) {
            return new JiClassInstance();
        }

        throw new RuntimeException("Class not found: " + className);
    }
}
