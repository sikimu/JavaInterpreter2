package jp.co.javainterpreter;

/**
 * ひとまとまりの処理を表すインターフェース
 */
public interface JiInstruction {

    record JiReturn(JiObject[] objects) implements JiInstruction {
    }
}
