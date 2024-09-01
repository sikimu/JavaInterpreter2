package jp.co.javainterpreter.object;

public class JiInteger extends JiObject {

    private final int value;

    public JiInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
