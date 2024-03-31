package jp.co.javainterpreter;

import java.util.ArrayList;

public class JiMethodInstance {

    public ArrayList<JiObject[]> objects = new ArrayList<>();

    public JiObject run() {
        for (JiObject[] code : objects) {
            if (code[0] instanceof JiObject.JiReturn) {
                return code[1];
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
