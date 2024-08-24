package jp.co.javainterpreter.token;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TokenTest {

    @Test
    void testトークン作成_public(){
        Token token = Token.create("public");
        assertEquals(TokenType.KEYWORD, token.type);
    }

    @Test
    void testトークン作成_class(){
        Token token = Token.create("class");
        assertEquals(TokenType.CLASS, token.type);
    }
}
