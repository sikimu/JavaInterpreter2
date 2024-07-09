package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiExpressionTest {

    @Test
    void 数字のみの計算() {
        {
            JiExpression jiExpression = new JiExpression("3");
            assertEquals(JiImmutableInteger.of(3), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("5");
            assertEquals(JiImmutableInteger.of(5), jiExpression.calculate());
        }
    }

    @Test
    void 足し算() {
        {
            JiExpression jiExpression = new JiExpression("3", "+", "5");
            assertEquals(JiImmutableInteger.of(8), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "+", "3");
            assertEquals(JiImmutableInteger.of(10), jiExpression.calculate());
        }
    }

    @Test
    void 引き算() {
        {
            JiExpression jiExpression = new JiExpression("3", "-", "5");
            assertEquals(JiImmutableInteger.of(-2), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "3");
            assertEquals(JiImmutableInteger.of(4), jiExpression.calculate());
        }
    }

    @Test
    void 掛け算() {
        {
            JiExpression jiExpression = new JiExpression("3", "*", "5");
            assertEquals(JiImmutableInteger.of(15), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "*", "3");
            assertEquals(JiImmutableInteger.of(21), jiExpression.calculate());
        }
    }

    @Test
    void 割り算() {
        {
            JiExpression jiExpression = new JiExpression("3", "/", "5");
            assertEquals(JiImmutableInteger.of(0), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "/", "3");
            assertEquals(JiImmutableInteger.of(2), jiExpression.calculate());
        }
    }

    @Test
    void 複数の演算子() {
        {
            JiExpression jiExpression = new JiExpression("3", "+", "5", "*", "2");
            assertEquals(JiImmutableInteger.of(13), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "3", "/", "3");
            assertEquals(JiImmutableInteger.of(6), jiExpression.calculate());
        }
    }

    @Test
    void 複数の演算子_括弧() {
        {
            JiExpression jiExpression = new JiExpression("(", "3", "+", "5", ")", "*", "2");
            assertEquals(JiImmutableInteger.of(16), jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "(", "3", "/", "3", ")");
            assertEquals(JiImmutableInteger.of(6), jiExpression.calculate());
        }
    }
}