package tests.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import calculator.ExpressionReader;

public class ExpressionReaderTest {

    @Test
    public void testSimpleExpression() {
        ExpressionReader reader = new ExpressionReader("1+ 2");

        assertEquals("1", reader.nextToken());
        assertEquals("+", reader.nextToken());
        assertEquals("2", reader.nextToken());
        assertEquals("#", reader.nextToken());
    }

    @Test
    public void testComplexExpression() {
        String expression = "1 / 2 * 3 + 4 - 5";

        ExpressionReader reader = new ExpressionReader(expression);

        String[] expectedTokens = expression.split(" ");
        for (String token : expectedTokens) {
            assertEquals(token, reader.nextToken());
        }
        assertEquals("#", reader.nextToken());
    }

    @Test
    public void testEmptyString() {
        ExpressionReader reader = new ExpressionReader("");

        assertEquals("#", reader.nextToken());
    }

    @Test
    public void testLongerNumbers() {
        ExpressionReader reader = new ExpressionReader("12345 /6789");

        assertEquals("12345", reader.nextToken());
        assertEquals("/", reader.nextToken());
        assertEquals("6789", reader.nextToken());
        assertEquals("#", reader.nextToken());
        assertEquals("#", reader.nextToken());
        assertEquals("#", reader.nextToken());
    }
}
