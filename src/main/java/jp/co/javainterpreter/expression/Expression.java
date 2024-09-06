package jp.co.javainterpreter.expression;

import jp.co.javainterpreter.object.JiObject;

public class Expression {

    final JiObject jiObject;

    public Expression(JiObject jiObject) {
        this.jiObject = jiObject;
    }

    public JiObject evaluate() {

        return jiObject;
    }
}
