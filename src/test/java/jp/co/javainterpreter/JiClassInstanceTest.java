package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiClassInstanceTest {

    @Test
    void test() {
        JiClassInstance jiClassInstance = new JiClassInstance(new JiClass());
        assertEquals(new JiObject.JiInt(1), jiClassInstance.callMethod("test"));
    }
}