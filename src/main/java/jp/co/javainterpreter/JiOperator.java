package jp.co.javainterpreter;

public class JiOperator {

    String value;

    public JiOperator(String value) {
        this.value = value;
    }

    public static JiOperator of(String value) {
        return new JiOperator(value);
    }

    public boolean isMultiplication() {
        return value.equals("*");
    }
}
