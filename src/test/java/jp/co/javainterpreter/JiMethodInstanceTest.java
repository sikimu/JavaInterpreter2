package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiMethodInstanceTest {

    @Test
    void run() {

        JiMethodInstance jiMethodInstance = new JiMethodInstance();
        jiMethodInstance.codes.add(new String[]{"return", "0"});
        JiObject jiObject = jiMethodInstance.run();
        assertEquals(jiObject.value(), "0");
    }
}