package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    @Test
    void test次の単語を取得する() {
        TokenStream tokenStream = new TokenStream(" public class");

        assertEquals(TokenType.PUBLIC, tokenStream.next().type);
        assertEquals(TokenType.CLASS, tokenStream.next().type);
    }

    @Test
    void testスキップ処理_スペースのみ() {
        int length = TokenStream.calculateSkipLength("  public");

        assertEquals(2, length);
    }

    @Test
    void testスキップ処理_1行コメント() {
        int length = TokenStream.calculateSkipLength("""
                // public
                class
                """);

        assertEquals(10, length);
    }

    @Test
    void testスキップ処理_複数行コメント() {
        int length = TokenStream.calculateSkipLength("""
                /* public
                class */a
                """);

        assertEquals(18, length);
    }

    @Test
    void testスキップ処理_複数行コメント_コメントが終わらない() {
        int length = TokenStream.calculateSkipLength("""
                /* public
                class a""");


        assertEquals(18, length);
    }

    @Test
    void testスキップ処理_コメントなし() {
        int length = TokenStream.calculateSkipLength("public");

        assertEquals(0, length);
    }

    @Test
    void testスキップ処理_複数種類() {
        int length = TokenStream.calculateSkipLength("""
                // public
                /* class */a
                """);
        assertEquals(21, length);
    }
}
