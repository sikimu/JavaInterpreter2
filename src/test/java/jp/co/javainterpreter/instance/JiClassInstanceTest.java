package jp.co.javainterpreter.instance;

import jp.co.javainterpreter.object.JiMethod;
import jp.co.javainterpreter.object.JiObject;
import jp.co.javainterpreter.object.JiString;
import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiClassInstanceTest {

    @Test
    void メソッド実行成功() {
        JiMethod method = new JiMethod("getString", new Token(TokenType.INT, "int"));
        method.addStatement(new JiReturnStatement(new JiString("Hello, World!")));
        JiClassInstance jiClassInstance = new JiClassInstance();
        JiObject result = jiClassInstance.executeMethod("getString");

        // JiObjectの型がJiStringであることを確認
        assertInstanceOf(JiString.class, result);
        assertEquals("Hello, World!", ((JiString) result).getValue());
    }
}