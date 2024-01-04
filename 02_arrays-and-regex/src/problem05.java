import java.util.Scanner;
import java.util.regex.Pattern;

public class problem05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hex;
        StringBuilder shadesOfGray = new StringBuilder();
        while(!(hex = input.nextLine().trim()).equals("")) {
            if(Pattern.matches("#([0-9A-Fa-f])([0-9A-Fa-f])((?=\\2)\\1|(?:\\1\\2){2})\\b", hex.toUpperCase()))
                shadesOfGray.append(hex).append("\n");
        }
        System.out.println(shadesOfGray);
    }
}
