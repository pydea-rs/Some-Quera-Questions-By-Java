import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String series = scanner.nextLine();
        int sum = scanner.nextInt(), numberOfCouples = 0;
        scanner.close();
        String couples = "";
        for (int i = 0; i < series.length(); i++) {
            int num = 0;
            int digitPositionMultiplier = 1;
            for (; i < series.length() && series.charAt(i) != ' ' && series.charAt(i) != '\t'; i++) {
                char digit = series.charAt(i);
                digit -= '0';
                num += digitPositionMultiplier * digit;
                digitPositionMultiplier *= 10;
            }
            for (int k = i + 1; k < series.length(); k++) {
                int num2 = 0;
                digitPositionMultiplier = 1;
                for (; k < series.length() && series.charAt(k) != ' ' && series.charAt(k) != '\t'; k++) {
                    char digit = series.charAt(k);
                    digit -= '0';
                    num2 += digitPositionMultiplier * digit;
                    digitPositionMultiplier *= 10;
                }
                if (num + num2 == sum) {
                    numberOfCouples++;
                    couples += Integer.toString(num) + " " + Integer.toString(num2) + "\n";
                }
            }
        }
        System.out.println(numberOfCouples);
        System.out.println(couples);
    }
}
