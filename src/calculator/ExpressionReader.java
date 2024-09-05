package calculator;

import calculator.operators.Operator;

public class ExpressionReader {
    private String expression;
    private int index;

    public static final String END_TOKEN = "#";

    public ExpressionReader(String expression) {
        this.expression = expression;
        this.index = 0;
    }

    public String nextToken() {
        if (isAtEnd()) {
            return END_TOKEN;
        }

        ignoreWhitespace();

        if (!isAtEnd() && Character.isDigit(this.expression.charAt(this.index))) {
            return number();
        } else if (!isAtEnd()) {
            return operator();
        } else {
            return END_TOKEN;
        }
    }

    private void ignoreWhitespace() {
        while (!isAtEnd() && Character.isWhitespace(this.expression.charAt(this.index))) {
            this.index++;
        }
    }

    private String number() {
        String value = "";

        while (!isAtEnd() && Character.isDigit(this.expression.charAt(this.index))) {
            value += this.expression.charAt(this.index++);
        }

        return value;
    }

    private String operator() {
        if (Operator.getValidTokens().contains(this.expression.charAt(this.index) + "")) {
            return this.expression.charAt(this.index++) + "";
        }

        return "#";
    }

    private boolean isAtEnd() {
        return this.index >= this.expression.length();
    }
}