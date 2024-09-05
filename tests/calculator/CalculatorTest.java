package tests.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import calculator.Calculator;

public class CalculatorTest {
    @Test
    public void testExpression() {
        Calculator calculator = new Calculator();

        assertEquals(7, calculator.evaluate("1 + 2 * 3"));
    }

    @Test
    public void testAnotherExpression() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.evaluate("1 * 2 + 3"));
    }

    @Test
    public void testParenthesizedExpression() {
        Calculator calculator = new Calculator();

        assertEquals(9, calculator.evaluate("(1 + 2) * 3"));
    }
}
