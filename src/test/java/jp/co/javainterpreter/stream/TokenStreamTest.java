package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    @Test
    void test次の単語を取得する_スペース() {
        TokenStream tokenStream = new TokenStream("public class");

        assertEquals(TokenType.PUBLIC, tokenStream.getNext().type);
        assertEquals(TokenType.CLASS, tokenStream.getNext().type);
    }

    @Test
    void test次の単語を取得する_タブ() {
        TokenStream tokenStream = new TokenStream("public\tclass");

        assertEquals(TokenType.PUBLIC, tokenStream.getNext().type);
        assertEquals(TokenType.CLASS, tokenStream.getNext().type);
    }

    @Test
    void test次の単語を取得する_改行() {
        TokenStream tokenStream = new TokenStream("public\n\rclass");

        assertEquals(TokenType.PUBLIC, tokenStream.getNext().type);
        assertEquals(TokenType.CLASS, tokenStream.getNext().type);
    }
}
