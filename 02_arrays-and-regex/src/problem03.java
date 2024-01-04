import java.util.Scanner;
import java.util.regex.Pattern;

public class problem03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        final String BASIC_MATH_REGEX = "[*-9][^,]*"; // 0-9, +, -, *, /

        Boolean isCharacterSetMathematical = Pattern.matches(BASIC_MATH_REGEX, expression); // first check

        isCharacterSetMathematical &= !Pattern.matches(".*\\d \\d.*", expression); // check that numbers are seperated by operator at everywhere

        isCharacterSetMathematical &= !Pattern.matches(".*\\s\\s.*", expression); // check that number of spaces are <= 1

        isCharacterSetMathematical &= !(Pattern.matches(".*[+\\-*/] [+\\-]\\s\\d.*", expression) || //ex: + - 2
                Pattern.matches(".*[+\\-*/][+\\-]\\s\\d.*", expression));//ex: +- 2 // check that there is not space between sign and number

        expression = expression.replace(" ", ""); //remove redundant spaces to make next steps easy

        isCharacterSetMathematical &= !Pattern.matches(".*[+\\-*/][*/].*", expression); // check there is no operator after another operator

        isCharacterSetMathematical &= !Pattern.matches(".*[+\\-*/][+\\-][+\\-].*", expression); // check there is no more than one sign for each number

        isCharacterSetMathematical &= !(Pattern.matches("[*/].*", expression) ||
               Pattern.matches(".*[+\\*/]", expression) || // ex: ... *
                Pattern.matches("[+\\-][+\\-].*", expression) ); //ex: * ... // check there is no more illegal char at the start or end

        System.out.println(isCharacterSetMathematical);
    }
}
