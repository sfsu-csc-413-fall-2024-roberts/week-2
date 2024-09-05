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
        validOperators.put(")", new RightParens());
    }

    public static Set<String> getValidTokens() {
        return validOperators.keySet();
    }

    public static Operator getOperator(String token) {
        return Operator.validOperators.get(token);
    }

    public abstract Operand execute(Operand operandOne, Operand operandTwo);

    public abstract int getPrecedence();

    public abstract String getLexeme();
}
