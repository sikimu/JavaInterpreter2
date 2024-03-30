package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiMethodInstanceTest {

    @Test
    void run() {

        JiMethodInstance jiMethodInstance = new JiMethodInstance();
        JiObject jiObject = jiMethodInstance.run();
        assertNull(jiObject);
    }
}