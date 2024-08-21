package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    @Test
    void test次の単語を取得する() {
        TokenStream tokenStream = new TokenStream(" public class");

        assertEquals(TokenType.PUBLIC, tokenStream.getNext().type);
        assertEquals(TokenType.CLASS, tokenStream.getNext().type);
    }

    @Test
    void testスキップ処理_スペースのみ() {
        TokenStream tokenStream = new TokenStream("  public");
        tokenStream.skip();

        assertEquals(tokenStream.position, 2);
    }

    @Test
    void testスキップ処理_1行コメント() {
        TokenStream tokenStream = new TokenStream("""
                // public
                class
                """);
        tokenStream.skip();

        assertEquals(10, tokenStream.position);
    }

    @Test
    void test次の単語を取得する_複数行コメント() {
        TokenStream tokenStream = new TokenStream("""
                /* public
                class */a
                """);
        tokenStream.skip();    

        assertEquals(18, tokenStream.position);
    }
}
