package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JiMethodManagerTest {

    @Test
    void getMethod() {

        JiClass jiClass = new JiClass("Test");
        JiMethod jiMethod1 = new JiMethod("jiMethod1");
        JiMethod jiMethod2 = new JiMethod("jiMethod2");

        JiMethodManager jiMethodManager = new JiMethodManager();
        jiMethodManager.add(jiClass, Set.of(jiMethod1, jiMethod2));

        assertTrue(jiMethodManager.getMethod(jiClass, "jiMethod1").isPresent());
        assertEquals(jiMethod1, jiMethodManager.getMethod(jiClass, "jiMethod1").get());
        assertTrue(jiMethodManager.getMethod(jiClass, "jiMethod2").isPresent());
        assertTrue(jiMethodManager.getMethod(jiClass, "jiMethod3").isEmpty());
    }
}