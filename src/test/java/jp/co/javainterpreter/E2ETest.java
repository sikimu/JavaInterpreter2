package jp.co.javainterpreter;

import jp.co.javainterpreter.object.JiInteger;
import jp.co.javainterpreter.object.JiObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * E2Eテスト
 */
public class E2ETest {

    // @Test
    public void testStaticMethodの呼び出し() {

        JavaInterpreter interpreter = new JavaInterpreter();
        interpreter.loadSource("jp.co.test", """
            public class Test {
                public static int add(int a, int b) {
                    return a + b;
                }
            }
        """);
        JiObject result = interpreter.callMethod("jp.co.test.Test", "add", new JiObject[]{new JiInteger(1), new JiInteger(2)});

        assertEquals(3, ((JiInteger)result).getValue());
    }
}
