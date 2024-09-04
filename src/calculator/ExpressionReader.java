package calculator;

import java.util.Set;

import calculator.operators.Operator;

public class ExpressionReader {
    private String expression;
    private int index;
    private Set<String> validOperators;

    public ExpressionReader(String expression) {
        this.expression = expression;
        this.validOperators = Operator.getValidOperators();
    }

    public String nextToken() {
        if (this.isAtEnd()) {
            return "#";
        }

        while (!isAtEnd() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }

        // Digit indicates number
        if (!isAtEnd() && Character.isDigit(expression.charAt(index))) {
            return this.number();
        } else {
            return this.operator();
        }
    }

    private boolean isAtEnd() {
        return this.index >= this.expression.length();
    }

    private String number() {
        String value = "";

        while (!isAtEnd() && Character.isDigit(expression.charAt(index))) {
            value += this.expression.charAt(index++);
        }

        return value;
    }

    private String operator() {
        if (!isAtEnd() && this.validOperators.contains(this.expression.charAt(this.index) + "")) {
            return this.expression.charAt(this.index++) + "";
        }

        return "#";
    }
}