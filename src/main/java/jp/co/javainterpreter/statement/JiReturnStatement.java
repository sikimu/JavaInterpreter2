package jp.co.javainterpreter.statement;

import jp.co.javainterpreter.object.JiObject;
import jp.co.javainterpreter.object.JiString;

public class JiReturnStatement implements JiStatement {

    JiObject object;

    public JiReturnStatement(JiString object) {

        this.object = object;
    }

    @Override
    public JiObject execute() {

        return object;
    }
}
