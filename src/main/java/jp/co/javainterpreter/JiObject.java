package jp.co.javainterpreter;

public sealed interface JiObject {

    record JiReturn() implements JiObject {
    }
    record JiInt(int value) implements JiObject {
    }
}
