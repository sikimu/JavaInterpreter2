package jp.co.javainterpreter.object;

public class JiString extends JiObject {
    private String value;

    public JiString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
