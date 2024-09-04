package calculator.operators;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import calculator.operands.Operand;

public abstract class Operator {

    private static Map<String, Operator> validOperators;
    static {
        validOperators = new HashMap<>();

        validOperators.put("+", new Add());
        validOperators.put("-", new Subtract());
        validOperators.put("*", new Multiply());
        validOperators.put("/", new Divide());
        validOperators.put("(", new LeftParens());
        validOperators.put(")", null);
    }

    public static Set<String> getValidOperators() {
        return validOperators.keySet();
    }

    public static Operator getOperator(String operator) {
        return validOperators.get(operator);
    }

    public abstract Operand execute(Operand operandOne, Operand operandTwo);

    public abstract int getPrecedence();

    @Override
    public abstract String toString();
}
