package jp.co.javainterpreter.token;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JiWordTest {

    @Test
    void findTest() {
        {
            Optional<JiWord> jiWord = JiWord.find("a", 0);
            assertTrue(jiWord.isPresent());
            assertEquals("a", jiWord.get().value());
        }
        {
            Optional<JiWord> jiWord = JiWord.find("a1 ", 0);
            assertTrue(jiWord.isPresent());
            assertEquals("a1", jiWord.get().value());
        }
        {
            Optional<JiWord> jiWord = JiWord.find("a", 1);
            assertFalse(jiWord.isPresent());
        }
    }
}