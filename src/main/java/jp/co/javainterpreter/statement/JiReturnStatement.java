package jp.co.javainterpreter.statement;

import jp.co.javainterpreter.object.JiObject;

public class JiReturnStatement implements JiStatement {

    JiObject object;

    public JiReturnStatement(JiObject object) {

        this.object = object;
    }

    @Override
    public JiObject execute() {

        return object;
    }
}
