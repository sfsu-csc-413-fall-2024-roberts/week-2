package calculator.operands;

public class Operand {
    private int value;

    public Operand(String value) {
        this.value = Integer.parseInt(value);
    }

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
