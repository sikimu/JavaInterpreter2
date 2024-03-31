package jp.co.javainterpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiObjectTest {

    @Test
    void test() {
        JiObject.JiInt jiInt = new JiObject.JiInt(1);
        assertEquals(1, jiInt.value());
    }
}