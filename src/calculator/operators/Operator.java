package calculator.operators;

import calculator.operands.Operand;

public abstract class Operator {
    
    public abstract Operand execute(Operand operandOne, Operand operandTwo);
    public abstract int getPrecedence();
}
