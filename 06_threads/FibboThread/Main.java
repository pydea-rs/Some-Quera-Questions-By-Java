package FibboThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        FibboThread ft = new FibboThread(n);
        ft.run();
        System.out.println(ft.F_n());
    }

}
