package jp.co.javainterpreter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiMethodInstanceTest {

    @ParameterizedTest
    @MethodSource("runProvider")
    void run(JiObject expected, JiObject[] input) {

        JiMethodInstance jiMethodInstance = new JiMethodInstance();
        jiMethodInstance.codes.add(input);
        JiObject jiObject = jiMethodInstance.run();
        assertEquals(jiObject, expected);
    }
    static Stream<Arguments> runProvider() {
        return Stream.of(
                Arguments.of(JiObject.create("0"), JiObject.createArrays("return", "0")),
                Arguments.of(JiObject.create("1"), JiObject.createArrays("return", "1"))
        );
    }
}