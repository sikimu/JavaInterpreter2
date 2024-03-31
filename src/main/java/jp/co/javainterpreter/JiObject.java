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

    static JiObject[] createArrays(String... values) {
        JiObject[] jiObjects = new JiObject[values.length];
        for (int i = 0; i < values.length; i++) {
            jiObjects[i] = create(values[i]);
        }
        return jiObjects;
    }

    record JiInt(int value) implements JiObject {
    }
}
