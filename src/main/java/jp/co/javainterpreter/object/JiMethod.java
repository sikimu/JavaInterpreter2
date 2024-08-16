package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiStatement;

public class JiMethod {
    private String name;
    private Class<?> returnType;

    public JiMethod(String name, Class<?> returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public JiObject execute() {
        return null;
    }

    public void addStatement(JiStatement statement) {
    }
}
