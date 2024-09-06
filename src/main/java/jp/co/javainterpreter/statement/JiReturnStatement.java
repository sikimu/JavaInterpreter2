package jp.co.javainterpreter.statement;

import jp.co.javainterpreter.expression.Expression;
import jp.co.javainterpreter.object.JiObject;

public class JiReturnStatement implements JiStatement {

    Expression expression;

    public JiReturnStatement(Expression expression) {

        this.expression = expression;
    }

    @Override
    public JiObject execute() {

        return expression.evaluate();
    }
}
