package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiClassTest {

    @Test
    void testメソッドの実行成功() {
        JiMethod method = new JiMethod("getString", new Token(TokenType.INT, "int"));
        method.addStatement(new JiReturnStatement(new JiString("Hello, World!")));

        JiClass jiClass = new JiClass("jp.co.javainterpreter.instance", "JiClassInstance");
        jiClass.addMethod(method);

        JiObject result = jiClass.executeMethod("getString");

        // JiObjectの型がJiStringであることを確認
        assertInstanceOf(JiString.class, result);
        assertEquals("Hello, World!", ((JiString) result).getValue());
    }
}