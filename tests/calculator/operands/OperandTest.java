package tests.calculator.operands;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import calculator.operands.Operand;

public class OperandTest {
    
    @Test
    public void testGetValue() {
        Operand operand = new Operand("42");
        assertEquals(42, operand.getValue());
    }

    @Test
    public void testStringValueConstructor() {
        Operand operand = new Operand("5");
        assertEquals(5, operand.getValue());
    }

    @Test
    public void testIntValueConstructor() {
        Operand operand = new Operand(99);
        assertEquals(99, operand.getValue());
    }
}
