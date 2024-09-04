package tests.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import calculator.Calculator;

public class CalculatorTest {
    @Test
    public void testSimpleExpression() {
        Calculator calculator = new Calculator();

        int result = calculator.evaluate("1+    2");

        assertEquals(3, result);
    }

    @Test
    public void testLongerExpression() {
        Calculator calculator = new Calculator();

        int result = calculator.evaluate("1 + 2 * 3");

        assertEquals(7, result);
    }

    @Test
    public void testParenthesizedExpression() {
        Calculator calculator = new Calculator();

        int result = calculator.evaluate("(1+ 2) * 3");

        assertEquals(9, result);
    }
}
