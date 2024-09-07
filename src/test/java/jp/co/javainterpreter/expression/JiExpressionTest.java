package jp.co.javainterpreter.expression;

import jp.co.javainterpreter.object.JiString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiExpressionTest {

    @Test
    void test文字列のみの計算式() {
        JiExpression jiExpression = new JiExpression(new JiString("Hello, World!"));
        assertEquals(new JiString("Hello, World!"), jiExpression.evaluate());
    }
}