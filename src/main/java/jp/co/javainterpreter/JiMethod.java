package jp.co.javainterpreter;

import java.util.ArrayList;

public class JiMethod {

    public final String name;

    public JiMethod(String name) {
        this.name = name;
    }

    public ArrayList<JiInstruction> instructions = new ArrayList<>();
}
