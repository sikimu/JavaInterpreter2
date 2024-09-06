package jp.co.javainterpreter.instance;

import jp.co.javainterpreter.expression.Expression;
import jp.co.javainterpreter.object.JiMethod;
import jp.co.javainterpreter.object.JiObject;
import jp.co.javainterpreter.object.JiString;
import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.token.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiInstanceTest {

    @Test
    void メソッド実行成功() {
        JiMethod method = new JiMethod("getString", new Token(Token.Type.INT, "int"));
        Expression expression = new Expression(new JiString("Hello, World!"));
        method.addStatement(new JiReturnStatement(expression));
        JiInstance jiClassInstance = new JiInstance();
        JiObject result = jiClassInstance.executeMethod("getString");

        // JiObjectの型がJiStringであることを確認
        assertInstanceOf(JiString.class, result);
        assertEquals("Hello, World!", ((JiString) result).getValue());
    }
}