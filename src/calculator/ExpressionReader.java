package calculator;

public class ExpressionReader {
    private int index;
    private String expression;

    public ExpressionReader(String expression) {
        this.index = 0;
        this.expression = expression;
    }

    public String nextToken() {
        while (this.index < this.expression.length() &&
                Character.isWhitespace(this.expression.charAt(this.index))) {
            this.index++;
        }

        if (this.index >= this.expression.length()) {
            return "#";
        }

        if (Character.isDigit(this.expression.charAt(index))) {
            return this.number();
        } else {
            return this.operator();
        }
    }

    private String number() {
        String temporaryNumber = "";

        while (this.index < this.expression.length() &&
                Character.isDigit(this.expression.charAt(this.index))) {
            temporaryNumber += this.expression.charAt(this.index);
            index++;
        }

        return temporaryNumber;
    }

    private String operator() {
        return this.expression.charAt(this.index++) + "";
    }

}
