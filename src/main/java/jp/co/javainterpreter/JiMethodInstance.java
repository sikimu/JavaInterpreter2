package jp.co.javainterpreter;

import java.util.ArrayList;

public class JiMethodInstance {

    public ArrayList<String[]> codes = new ArrayList<>();

    public JiInt run() {
        for (String[] code : codes) {
            if (code[0].equals("return")) {
                return new JiInt(code[1]);
            }
        }
        // 例外処理
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
