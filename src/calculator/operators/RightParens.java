package calculator.operators;

import calculator.operands.Operand;

public class RightParens extends Operator {

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return null;
    }

    @Override
    public int getPrecedence() {
        return Integer.MIN_VALUE;
    }

    @Override
    public String getLexeme() {
        return ")";
    }

}
