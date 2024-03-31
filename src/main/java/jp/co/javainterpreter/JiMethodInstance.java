package jp.co.javainterpreter;

class JiMethodInstance {

    final JiMethod jiMethod;

    public JiMethodInstance(JiMethod jiMethod) {
        this.jiMethod = jiMethod;
    }

    public JiObject run() {
        for (JiInstruction code : jiMethod.instructions) {
            if (code instanceof JiInstruction.JiReturn jiReturn) {
                return jiReturn.objects()[0];
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
