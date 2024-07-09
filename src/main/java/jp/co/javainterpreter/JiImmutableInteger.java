package jp.co.javainterpreter;

public record JiImmutableInteger(int value) {

    public static JiImmutableInteger of(int value) {
        return new JiImmutableInteger(value);
    }

    public JiImmutableInteger add(JiImmutableInteger other) {
        return new JiImmutableInteger(this.value + other.value);
    }

    public JiImmutableInteger subtract(JiImmutableInteger other) {
        return new JiImmutableInteger(this.value - other.value);
    }

    public JiImmutableInteger multiply(JiImmutableInteger other) {
        return new JiImmutableInteger(this.value * other.value);
    }

    public JiImmutableInteger divide(JiImmutableInteger other) {
        return new JiImmutableInteger(this.value / other.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JiImmutableInteger) {
            return this.value == ((JiImmutableInteger) obj).value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
