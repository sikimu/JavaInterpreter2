package jp.co.javainterpreter;

public sealed interface JiObject {

    static JiObject create(String value) {
        // intに変換できる場合はint型に変換
        try {
            return new JiInt(Integer.parseInt(value));
        } catch (NumberFormatException ignored) {
        }

        // 不明エラー
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    record JiReturn() implements JiObject {
    }
    record JiInt(int value) implements JiObject {
    }
}
