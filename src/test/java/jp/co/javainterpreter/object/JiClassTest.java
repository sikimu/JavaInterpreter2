package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.token.Token;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JiClassTest {

    @Test
    void testクラスの作成() {
        JiClass jiClass = new JiClass("jp.co.javainterpreter", "test");
        assertEquals("jp.co.javainterpreter", jiClass.packageName);
        assertEquals("test", jiClass.className);
    }

    @Test
    void testクラスボディの作成() {
        JiClass jiClass = new JiClass("jp.co.javainterpreter", "test");

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(Token.Type.VOID, "void"));
        tokens.add(new Token(Token.Type.IDENTIFIER, "a"));
        tokens.add(new Token(Token.Type.L_PAREN, "("));
        tokens.add(new Token(Token.Type.INT, ")"));
        tokens.add(new Token(Token.Type.IDENTIFIER, "param"));
        tokens.add(new Token(Token.Type.R_PAREN, ")"));
        tokens.add(new Token(Token.Type.L_BRACE, "{"));
        tokens.add(new Token(Token.Type.R_BRACE, "}"));

        jiClass.loadBody(tokens);

        assertEquals(1, jiClass.methods.size());
    }

    @Test
    void testメソッドの実行成功() {
        JiMethod method = new JiMethod("getString", new Token(Token.Type.INT, "int"));
        method.addStatement(new JiReturnStatement(new JiString("Hello, World!")));

        JiClass jiClass = new JiClass("jp.co.javainterpreter.instance", "JiClassInstance");
        jiClass.addMethod(method);

        JiObject result = jiClass.executeMethod("getString");

        // JiObjectの型がJiStringであることを確認
        assertInstanceOf(JiString.class, result);
        assertEquals("Hello, World!", ((JiString) result).getValue());
    }
}