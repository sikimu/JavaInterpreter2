package jp.co.javainterpreter;

class JiMethodInstance {

    final JiMethod jiMethod;

    public JiMethodInstance(JiMethod jiMethod) {
        this.jiMethod = jiMethod;
    }

    public JiObject run() {
        for (JiObject[] code : jiMethod.objects) {
            if (code[0] instanceof JiObject.JiReturn) {
                return code[1];
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
