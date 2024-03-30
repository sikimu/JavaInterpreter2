package jp.co.javainterpreter;

public sealed interface JiObject {

    record JiReturn() implements JiObject {
    }
    public record JiInt(int value) implements JiObject {
    }
}
