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

        String token = reader.nextToken();
        while (token != ExpressionReader.END_TOKEN) {
            if (Character.isDigit(token.charAt(0))) {
                operands.push(new Operand(token));
            } else if (token.equals("(")) {
                operators.push(Operator.getOperator(token));
            } else if (token.equals(")")) {
                while (!this.operators.peek().getLexeme().equals("(")) {
                    processOperator();
                }

                this.operators.pop();
            } else {
                Operator currentOperator = Operator.getOperator(token);

                while (!this.operators.empty()
                        && this.operators.peek().getPrecedence() >= currentOperator.getPrecedence()) {
                    processOperator();
                }

                this.operators.push(currentOperator);
            }

            token = reader.nextToken();
        }

        while (!this.operators.empty()) {
            processOperator();
        }

        return this.operands.pop().getValue();
    }

    private void processOperator() {
        Operator operator = this.operators.pop();

        Operand second = this.operands.pop();
        Operand first = this.operands.pop();

        this.operands.push(
                operator.execute(first, second));
    }
}
