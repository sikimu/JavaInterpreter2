package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    @Test
    void test次の単語を取得する_public() {
        TokenStream tokenStream = new TokenStream("public");
        Token token = tokenStream.getNext();

        assertEquals(TokenType.PUBLIC, token.type);
    }

    @Test
    void test次の単語を取得する_class() {
        TokenStream tokenStream = new TokenStream("class");
        Token token = tokenStream.getNext();

        assertEquals(TokenType.CLASS, token.type);
    }
}
