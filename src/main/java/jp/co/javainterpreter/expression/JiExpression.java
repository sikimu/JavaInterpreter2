package jp.co.javainterpreter.expression;

import jp.co.javainterpreter.object.JiObject;

public class JiExpression {

    final JiObject jiObject;

    public JiExpression(JiObject jiObject) {
        this.jiObject = jiObject;
    }

    public JiObject evaluate() {

        return jiObject;
    }
}
