package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class test１文字目を解析してタイプを判定するテスト {

    @Test
    void test１文字目の判定() {

        // 空白や改行
        assertEquals(TokenType.SPACE, TokenStream.analyze(' '));
        assertEquals(TokenType.SPACE, TokenStream.analyze('\n'));
        assertEquals(TokenType.SPACE, TokenStream.analyze('\t'));

        // 数字
        assertEquals(TokenType.NUMBER, TokenStream.analyze('1'));
        assertEquals(TokenType.NUMBER, TokenStream.analyze('9'));

        // 文字
        assertEquals(TokenType.CHARACTER, TokenStream.analyze('a'));
        assertEquals(TokenType.CHARACTER, TokenStream.analyze('z'));

        // 比較演算子
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('>'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('<'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('='));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('!'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('&'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('|'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('^'));
        assertEquals(TokenType.COMPARISON_OPERATOR, TokenStream.analyze('~'));

        // 算術演算子
        assertEquals(TokenType.ARITHMETIC_OPERATOR, TokenStream.analyze('+'));
        assertEquals(TokenType.ARITHMETIC_OPERATOR, TokenStream.analyze('-'));
        assertEquals(TokenType.ARITHMETIC_OPERATOR, TokenStream.analyze('*'));
        assertEquals(TokenType.ARITHMETIC_OPERATOR, TokenStream.analyze('/'));
        assertEquals(TokenType.ARITHMETIC_OPERATOR, TokenStream.analyze('%'));

        // 括弧
        assertEquals(TokenType.BRACKET, TokenStream.analyze('('));
        assertEquals(TokenType.BRACKET, TokenStream.analyze(')'));
        assertEquals(TokenType.BRACKET, TokenStream.analyze('['));
        assertEquals(TokenType.BRACKET, TokenStream.analyze(']'));
        assertEquals(TokenType.BRACKET, TokenStream.analyze('{'));
        assertEquals(TokenType.BRACKET, TokenStream.analyze('}'));

        // 区切り文字
        assertEquals(TokenType.DELIMITER, TokenStream.analyze(','));
        assertEquals(TokenType.DELIMITER, TokenStream.analyze(';'));
        assertEquals(TokenType.DELIMITER, TokenStream.analyze('.'));
        assertEquals(TokenType.DELIMITER, TokenStream.analyze(':'));

        // "や'
        assertEquals(TokenType.QUOTATION, TokenStream.analyze('"'));
        assertEquals(TokenType.QUOTATION, TokenStream.analyze('\''));

    }
}