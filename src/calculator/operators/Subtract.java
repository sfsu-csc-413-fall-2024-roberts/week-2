package calculator.operators;

import calculator.operands.Operand;

public class Subtract extends Operator {

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(
                operandOne.getValue() - operandTwo.getValue());
    }

    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    public String toString() {
        return "-";
    }
}
