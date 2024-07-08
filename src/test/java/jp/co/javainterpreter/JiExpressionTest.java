package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiExpressionTest {

    @Test
    void 数字のみの計算() {
        {
            JiExpression jiExpression = new JiExpression("3");
            assertEquals(3, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("5");
            assertEquals(5, jiExpression.calculate());
        }
    }

    @Test
    void 足し算() {
        {
            JiExpression jiExpression = new JiExpression("3", "+", "5");
            assertEquals(8, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "+", "3");
            assertEquals(10, jiExpression.calculate());
        }
    }

    @Test
    void 引き算() {
        {
            JiExpression jiExpression = new JiExpression("3", "-", "5");
            assertEquals(-2, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "3");
            assertEquals(4, jiExpression.calculate());
        }
    }

    @Test
    void 掛け算() {
        {
            JiExpression jiExpression = new JiExpression("3", "*", "5");
            assertEquals(15, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "*", "3");
            assertEquals(21, jiExpression.calculate());
        }
    }

    @Test
    void 割り算() {
        {
            JiExpression jiExpression = new JiExpression("3", "/", "5");
            assertEquals(0, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "/", "3");
            assertEquals(2, jiExpression.calculate());
        }
    }

    @Test
    void 複数の演算子() {
        {
            JiExpression jiExpression = new JiExpression("3", "+", "5", "*", "2");
            assertEquals(13, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "3", "/", "3");
            assertEquals(6, jiExpression.calculate());
        }
    }

    @Test
    void 複数の演算子_括弧() {
        {
            JiExpression jiExpression = new JiExpression("(", "3", "+", "5", ")", "*", "2");
            assertEquals(16, jiExpression.calculate());
        }
        {
            JiExpression jiExpression = new JiExpression("7", "-", "(", "3", "/", "3", ")");
            assertEquals(6, jiExpression.calculate());
        }
    }
}