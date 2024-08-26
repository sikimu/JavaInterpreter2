package jp.co.javainterpreter.token;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TokenTest {

    @Test
    void testトークン作成_public(){
        Token token = Token.create("public");
        assertEquals(Token.Type.PUBLIC, token.type);
    }

    @Test
    void testトークン作成_class(){
        Token token = Token.create("class");
        assertEquals(Token.Type.CLASS, token.type);
    }
}
