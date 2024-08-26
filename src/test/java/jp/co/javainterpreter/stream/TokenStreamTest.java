package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    @Test
    void test次のトークンを取得する() {
        TokenStream tokenStream = new TokenStream(" public class");

        assertEquals(Token.Type.PUBLIC, tokenStream.next().type);
        assertEquals(Token.Type.CLASS, tokenStream.next().type);
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

    @Test
    void test次の数字を取得する_文末() {

        assertEquals("123", TokenStream.seekNumber("123"));
    }

    @Test
    void test次の数字を取得する_空白() {

        assertEquals("123", TokenStream.seekNumber("123 a"));
    }

    @Test
    void test次の数字を取得する_演算子() {

        assertEquals("123", TokenStream.seekNumber("123/bbb"));
    }

    @Test
    void test次の数字を取得する_小数点() {

        assertEquals("0.1", TokenStream.seekNumber("0.1"));
        assertEquals("0.1", TokenStream.seekNumber("0.1/bbb"));
    }

    @Test
    void test次の特殊文字を取得する_1文字() {

        assertEquals("+", TokenStream.seekSymbol("+"));
    }

    @Test
    void test次の特殊文字を取得する_2文字() {

        assertEquals("++", TokenStream.seekSymbol("++"));
    }

    @Test
    void test次の文字列を取得する_文末() {

        assertEquals("public", TokenStream.seekString("public"));
    }

    @Test
    void test次の文字列を取得する_空白() {

        assertEquals("public", TokenStream.seekString("public class"));
    }

    @Test
    void test次の文字列を取得する_演算子() {

        assertEquals("public", TokenStream.seekString("public+class"));
    }
}
