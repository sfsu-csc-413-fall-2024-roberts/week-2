package calculator;

import java.util.Stack;

import calculator.operands.Operand;
import calculator.operators.Operator;

public class Calculator {
    private Stack<Operand> operands;
    private Stack<Operator> operators;

    public Calculator() {
        this.operands = new Stack<>();
        this.operators = new Stack<>();
    }

    public int evaluate(String expression) {
        ExpressionReader reader = new ExpressionReader(expression);

        String currentToken = reader.nextToken();
        while (currentToken != "#") {
            if (Character.isDigit(currentToken.charAt(0))) {
                this.operands.push(new Operand(currentToken));
            } else if (currentToken.equals("(")) {
                this.operators.push(Operator.getOperator("("));
            } else if (currentToken.equals(")")) {
                while (!this.operators.peek().toString().equals("(")) {
                    this.process();
                }

                this.operators.pop();
            } else {
                Operator currentOperator = Operator.getOperator(currentToken);

                while (!this.operators.empty()
                        && this.operators.peek().getPrecedence() >= currentOperator.getPrecedence()) {
                    this.process();
                }

                this.operators.push(currentOperator);
            }

            currentToken = reader.nextToken();
        }

        while (!this.operators.empty()) {
            this.process();
        }

        return this.operands.pop().getValue();
    }

    private void process() {
        Operator operator = this.operators.pop();

        Operand second = this.operands.pop();
        Operand first = this.operands.pop();

        Operand result = operator.execute(first, second);
        this.operands.push(result);
    }
}
