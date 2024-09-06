package jp.co.javainterpreter.statement;

import jp.co.javainterpreter.expression.JiExpression;
import jp.co.javainterpreter.object.JiObject;

public class JiReturnStatement implements JiStatement {

    JiExpression jiExpression;

    public JiReturnStatement(JiExpression jiExpression) {

        this.jiExpression = jiExpression;
    }

    @Override
    public JiObject execute() {

        return jiExpression.evaluate();
    }
}
