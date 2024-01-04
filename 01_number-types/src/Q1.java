import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // pseudo-prime numbers
        Scanner scanner = new Scanner(System.in);

        String line, result = "";
        while (!(line = scanner.nextLine()).isEmpty()) {
            int number = Integer.parseInt(line);
            int numberOfDivisors = 0;
            final int halfNumber = number / 2;
            // if the number has only and only another divisor between 2 and number/2 =>
            // then its pseudo-prime
            for (int i = 2; i <= halfNumber; i++) {
                if (number % i == 0) {
                    numberOfDivisors++;
                }
            }
            result += numberOfDivisors == 1 ? "Yes\n" : "No\n"; // two other divisors are 1 and 'number' itself
        }
        scanner.close();
        System.out.println(result);
    }
}
