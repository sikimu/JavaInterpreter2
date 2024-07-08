package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaInterpreterTest {

    @Test
    void splitByOperatorsAndDelimiters(){
        // / で分割
        assertEquals(Arrays.asList("a", "/", "b"), JavaInterpreter.splitByOperatorsAndDelimiters("a/b"));
        // += で分割
        assertEquals(Arrays.asList("a", "+=", "b"), JavaInterpreter.splitByOperatorsAndDelimiters("a+=b"));
        // 演算子から始まる場合
        assertEquals(Arrays.asList("+=", "b"), JavaInterpreter.splitByOperatorsAndDelimiters("+=b"));
        // 演算子で終わる場合
        assertEquals(Arrays.asList("a", "+="), JavaInterpreter.splitByOperatorsAndDelimiters("a+="));
    }

    @Test
    void splitByWhitespace(){
        // 空白で分割
        assertEquals(Arrays.asList("a", "b", "c"), JavaInterpreter.splitByWhitespace("a b c"));
        // 空白が連続する場合
        assertEquals(Arrays.asList("a", "b", "c"), JavaInterpreter.splitByWhitespace("a  b   c"));
        // 空白で始まる場合
        assertEquals(Arrays.asList("a", "b", "c"), JavaInterpreter.splitByWhitespace(" a b c"));
        // 空白で終わる場合
        assertEquals(Arrays.asList("a", "b", "c"), JavaInterpreter.splitByWhitespace("a b c "));
        // タブで分割
        assertEquals(Arrays.asList("a", "b", "c"), JavaInterpreter.splitByWhitespace("a\tb\tc"));
    }

    @Test
    void createWordList(){
        // 単語のリストを作成
        assertEquals(Arrays.asList("a", "+=", "b", "c", "d"), JavaInterpreter.createWordList(new String[]{"a += b", "c d"}));
    }
}