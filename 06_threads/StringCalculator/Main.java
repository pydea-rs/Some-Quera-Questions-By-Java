package StringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String operation = scanner.next();

            if(operation.equals("OFF"))
                return;
            String input = scanner.nextLine().trim();
            StringCalculator stringCalculator = new StringCalculator(input);
            String result;
            try {

                switch (operation) {
                    case "to_upper":
                        result = stringCalculator.toUpper();
                        break;
                    case "to_lower":
                        result = stringCalculator.toLower();
                        break;
                    case "camel_case":
                        result = stringCalculator.toCamelCase();
                        break;
                    case "capital":
                        result = stringCalculator.toCapitalCase();
                        break;
                    case "encode":
                        result = stringCalculator.encode();
                        break;
                    case "decode":
                        result = stringCalculator.decode();
                        break;
                    default:
                        throw new Exception("ERROR: Operation not recognized!");
                }
                System.out.println(result);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
