import java.util.Scanner;

public class Q5 {
    public static char toUpperCase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            ch += 'A' - 'a';
        }
        return ch;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        String output = "";

        while (!(command = scanner.nextLine()).equals("finish")) {
            if (command.equals("-skip")) {
                output += "Next Music";
            } else {
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == '-' && i + 1 < command.length() && command.charAt(i + 1) == 'p') {
                        output += "Play Music";
                        i += 2;
                    } else if (command.charAt(i) == '@') {
                        boolean atSentenceStart = i == 0;
                        if (!atSentenceStart) {
                            output += '\"';
                        } else {
                            output += '@';
                        }

                        for (i++; i < command.length() && command.charAt(i) != ' ' && command.charAt(i) != '\t'; i++)
                            output += toUpperCase(command.charAt(i));
                        if (!atSentenceStart) {
                            output += '\"';
                        }
                    }
                    if (i < command.length())
                        output += command.charAt(i);
                }

            }
            output += "\n";
        }
        output += "Bye bye!";
        System.out.println(output);
        scanner.close();
    }
}