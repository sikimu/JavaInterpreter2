package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiClassInstanceTest {

    @Test
    void test() {
        JiClass jiClass = new JiClass();

        JiMethodInstanceFactory jiMethodInstanceFactory = new JiMethodInstanceFactory();

        JiClassInstance jiClassInstance = new JiClassInstance(jiClass, jiMethodInstanceFactory);
        assertEquals(new JiObject.JiInt(1), jiClassInstance.callMethod("test"));
    }
}