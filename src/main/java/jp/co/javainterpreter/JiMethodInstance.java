package jp.co.javainterpreter;

record JiMethodInstance(JiMethod jiMethod) {

    public JiObject run() {
        for (JiInstruction code : jiMethod.instructions) {
            if (code instanceof JiInstruction.JiReturn jiReturn) {
                if(jiReturn.objects().length == 1) {
                    return jiReturn.objects()[0];
                }
                JiObject[] objects = jiReturn.objects();
                JiObject left = objects[0];
                JiObject right = objects[2];
                if (objects[1] instanceof JiObject.JiAdd) {
                    return new JiObject.JiInt(((JiObject.JiInt) left).value() + ((JiObject.JiInt) right).value());
                }
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
