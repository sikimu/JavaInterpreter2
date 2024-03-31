package jp.co.javainterpreter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiMethodInstanceTest {

    @ParameterizedTest
    @MethodSource("runProvider")
    void run(JiObject expected, JiInstruction input) {

        JiMethod jiMethod = new JiMethod();
        jiMethod.instructions.add(input);
        JiMethodInstance jiMethodInstance = new JiMethodInstance(jiMethod);
        JiObject jiObject = jiMethodInstance.run();
        assertEquals(jiObject, expected);
    }
    static Stream<Arguments> runProvider() {
        return Stream.of(
            Arguments.of(JiObject.create("0"), new JiInstruction.JiReturn(JiObject.createArrays("0"))),
            Arguments.of(JiObject.create("1"), new JiInstruction.JiReturn(JiObject.createArrays("1"))),
            Arguments.of(JiObject.create("2"), new JiInstruction.JiReturn(JiObject.createArrays("1", "+", "1"))),
            Arguments.of(JiObject.create("3"), new JiInstruction.JiReturn(JiObject.createArrays("1", "+", "1", "+", "1"))),
        );
    }
}