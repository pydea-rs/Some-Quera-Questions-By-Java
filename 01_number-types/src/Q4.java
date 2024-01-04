import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int numberInReverse = 0, temp = num; // = num != 0 ? 0 : 1;
        int zerosOnRight = 0;
        while (temp % 10 == 0) {
            zerosOnRight++;
            temp /= 10;
        }
        while (temp > 0) {
            numberInReverse = numberInReverse * 10 + temp % 10;
            temp /= 10;
            // digits++;
        }
        int longLength = 0, longPalindrome = 0;
        while (num > 0) {
            temp = numberInReverse;
            int tempZerosOnRight = zerosOnRight;
            // if(num % 10 != 0 || tempZerosOnRight == 0)
            for (int rd = num % 10; temp > 0 && rd != temp % 10; temp /= 10)
                ;

            if (temp > 0) {
                int ntemp = num, length = 0, palindrome = 0;
                int digitPositionMultiplier = 1;
                while (temp > 0 && ntemp % 10 == temp % 10) {
                    palindrome = palindrome + digitPositionMultiplier * (ntemp % 10);
                    digitPositionMultiplier *= 10;
                    length++;
                    temp /= 10;
                    ntemp /= 10;
                }
                if (ntemp > 0 && temp == 0) {
                    while (ntemp > 0 && ntemp % 10 == 0 && tempZerosOnRight > 0) {
                        ntemp /= 10;
                        tempZerosOnRight--;
                        length++;
                    }
                }
                if (length >= longLength) {
                    longLength = length;
                    longPalindrome = palindrome;
                }
            }

            num /= 10;
        }
        System.out.println(longPalindrome);
        System.out.println(longLength);
    }
}
