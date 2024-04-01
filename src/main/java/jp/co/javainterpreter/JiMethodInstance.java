package jp.co.javainterpreter;

record JiMethodInstance(JiMethod jiMethod) {

    public JiObject run() {
        for (JiInstruction code : jiMethod.instructions) {
            if (code instanceof JiInstruction.JiReturn jiReturn) {
                return calculate(jiReturn.objects());
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private JiObject calculate(JiObject[] objects) {
        JiObject result = objects[0];
        for (int i = 1; i < objects.length; i += 2) {
            JiObject operator = objects[i];
            JiObject operand = objects[i + 1];
            result = switch (operator) {
                case JiObject.JiAdd ignored ->
                        new JiObject.JiInt(((JiObject.JiInt) result).value() + ((JiObject.JiInt) operand).value());
                case JiObject.JiSub ignored ->
                        new JiObject.JiInt(((JiObject.JiInt) result).value() - ((JiObject.JiInt) operand).value());
                case JiObject.JiMul ignored ->
                        new JiObject.JiInt(((JiObject.JiInt) result).value() * ((JiObject.JiInt) operand).value());
                case JiObject.JiDiv ignored ->
                        new JiObject.JiInt(((JiObject.JiInt) result).value() / ((JiObject.JiInt) operand).value());
                case null, default ->
                    // 例外処理
                        throw new UnsupportedOperationException("Unimplemented method 'calculate'");
            };
        }
        return result;
    }

}
