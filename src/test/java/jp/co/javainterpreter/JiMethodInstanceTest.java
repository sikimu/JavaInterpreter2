package jp.co.javainterpreter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiMethodInstanceTest {

    @ParameterizedTest
    @MethodSource("runProvider")
    void run(String expected, String input) {

        JiMethodInstance jiMethodInstance = new JiMethodInstance();
        jiMethodInstance.codes.add(new String[]{"return", input});
        JiObject jiObject = jiMethodInstance.run();
        assertEquals(jiObject.value(), expected);
    }
    static Stream<Arguments> runProvider() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("1", "1")
        );
    }
}