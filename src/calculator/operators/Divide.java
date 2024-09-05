package calculator.operators;

import calculator.operands.Operand;

public class Divide extends Operator {

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(
                operandOne.getValue() / operandTwo.getValue());
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public String getLexeme() {
        return "/";
    }

}
