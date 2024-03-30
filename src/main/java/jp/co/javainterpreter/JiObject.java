package jp.co.javainterpreter;

public sealed interface JiObject {
    public record JiInt(String value) implements JiObject {
    }
}
