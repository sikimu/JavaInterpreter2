package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaInterpreterTest {

    @Test
    void testRemoveSingleComment() {
        assertEquals("a", JavaInterpreter.removeSingleComment("a"));
        assertEquals("a", JavaInterpreter.removeSingleComment("a//b"));
        assertEquals("a\nc", JavaInterpreter.removeSingleComment("a//b\nc"));
        assertEquals("", JavaInterpreter.removeSingleComment("//a"));
    }

    @Test
    void testRemoveMultiComment() {
        assertEquals("a", JavaInterpreter.removeMultiComment("a"));
        assertEquals("a", JavaInterpreter.removeMultiComment("a/*b*/"));
        assertEquals("a\nc", JavaInterpreter.removeMultiComment("a/*b*/\nc"));
        assertEquals("", JavaInterpreter.removeMultiComment("/*a*/"));
        assertEquals("", JavaInterpreter.removeMultiComment("/*a\nb*/"));
    }

    @Test
    void testSkipWhiteSpace() {
        assertEquals(0, JavaInterpreter.skipWhiteSpace("", 0));
        assertEquals(0, JavaInterpreter.skipWhiteSpace("a", 0));
        assertEquals(0, JavaInterpreter.skipWhiteSpace(" a", 1));
        assertEquals(1, JavaInterpreter.skipWhiteSpace(" a", 0));
        assertEquals(0, JavaInterpreter.skipWhiteSpace(" a", 2));
        assertEquals(1, JavaInterpreter.skipWhiteSpace(" a ", 2));
    }
}