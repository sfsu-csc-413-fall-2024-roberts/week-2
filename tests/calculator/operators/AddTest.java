package tests.calculator.operators;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import calculator.operands.Operand;
import calculator.operators.Add;

public class AddTest {

    @Test
    public void testExecute() {
        Operand operandOne = new Operand("42");
        Operand operandTwo = new Operand(58);

        Add addOperation = new Add();

        assertEquals(100, addOperation.execute(operandOne, operandTwo).getValue());
    }

    @Test
    public void testGetPrecedence() {
        Add operation = new Add();

        assertEquals(1, operation.getPrecedence());
    }
}
