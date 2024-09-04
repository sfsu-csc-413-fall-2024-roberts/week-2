package calculator;

public class Driver {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java Calculator \"1 + 2 * 3\"");
            System.exit(1);
        }

        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate(args[0]));
    }
}

// java Calculator "1 + 2"
//
// java Calculator
// > 1 + 2 * 3
// 7
// >
