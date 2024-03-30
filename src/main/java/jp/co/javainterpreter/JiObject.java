package jp.co.javainterpreter;

public sealed interface JiObject {
    record JiReturn() implements JiObject {
    }
    public record JiInt(String value) implements JiObject {
    }
}
