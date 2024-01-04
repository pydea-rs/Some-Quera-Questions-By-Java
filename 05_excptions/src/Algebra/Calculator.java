
package Algebra;
import java.util.regex.Pattern;

public class Calculator {
    public double calculateAlgebra(String algebra) throws IllegalAlgebraString, OperatorMisMatchException {
        String[] parts = algebra.split("\\s+");
        if(parts.length != 3)
            throw new IllegalAlgebraString(algebra);
        if(!Pattern.matches(parts[0], "-?\\d+.\\d+"))
            throw new NumberFormatException(parts[0] + " is not a number.");
        if(!Pattern.matches(parts[2], "-?\\d+.\\d+"))
            throw new NumberFormatException(parts[2] + " is not a number.");

        final double a = Double.parseDouble(parts[0]), b = Double.parseDouble(parts[2]);
        switch(parts[1]) {
            case "+":
                return (new Add()).calculate(a, b);
            case "-":
                return (new Subtract()).calculate(a, b);
            case "*":
                return (new Multiply()).calculate(a, b);
            case "/":
                if(b == 0)
                    throw new ArithmeticException("Division on zero is not allowed");
                return (new Division()).calculate(a, b);
            default:
                throw new OperatorMisMatchException(parts[1]);
        }
    }
}

class IllegalAlgebraString extends Exception {
    public IllegalAlgebraString(String illegalAlgebra) {
        super("Algebra " + illegalAlgebra + " is invalid.");
    }
}

class OperatorMisMatchException extends Exception {
    public OperatorMisMatchException(String invalidOperator) {
        super("Operator " + invalidOperator + " is invalid.");
    }
}
