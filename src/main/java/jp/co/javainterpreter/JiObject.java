package jp.co.javainterpreter;

public sealed interface JiObject {

    static JiObject create(String value) {
        if("return".equals(value)) {
            return new JiReturn();
        }

        // intに変換できる場合はint型に変換
        try {
            return new JiInt(Integer.parseInt(value));
        } catch (NumberFormatException ignored) {
        }

        // 不明エラー
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    static JiObject[] createArrays(String... valus) {
        JiObject[] jiObjects = new JiObject[valus.length];
        for (int i = 0; i < valus.length; i++) {
            jiObjects[i] = create(valus[i]);
        }
        return jiObjects;
    }

    record JiReturn() implements JiObject {
    }
    record JiInt(int value) implements JiObject {
    }
}
