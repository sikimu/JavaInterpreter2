package jp.co.javainterpreter;

import jp.co.javainterpreter.token.JiWhitespace;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JiWhitespaceTest {

    @Test
    void findTest() {
        {
            Optional<JiWhitespace> jiWhitespace = JiWhitespace.find("  ", 0);
            assertTrue(jiWhitespace.isPresent());
            assertEquals("  ", jiWhitespace.get().value());
        }
        {
            Optional<JiWhitespace> jiWhitespace = JiWhitespace.find("\na", 0);
            assertTrue(jiWhitespace.isPresent());
            assertEquals("\n", jiWhitespace.get().value());
        }
        {
            Optional<JiWhitespace> jiWhitespace = JiWhitespace.find("a", 0);
            assertFalse(jiWhitespace.isPresent());
        }
        {
            Optional<JiWhitespace> jiWhitespace = JiWhitespace.find("\na", 1);
            assertFalse(jiWhitespace.isPresent());
        }
    }
}