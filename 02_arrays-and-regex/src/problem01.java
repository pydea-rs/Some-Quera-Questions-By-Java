import java.util.Scanner;

public class problem01 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        final int N = scanner.nextInt(), S = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();
        int subArrayFirstItemIndex = 0,
                subArrayLastItemIndex = -1;
        for( ; subArrayFirstItemIndex < N; subArrayFirstItemIndex++) {
            int subSum = arr[subArrayFirstItemIndex],
                    i = subArrayFirstItemIndex + 1;
            for( ; subSum < S && i < N; i++)
                subSum += arr[i];

            if(subSum == S) {
                subArrayLastItemIndex = i - 1; // because i is incremented in the last loop step
                break;
            }
        }

        System.out.println(
                subArrayFirstItemIndex < N && subArrayLastItemIndex > 0
                ? String.format("%d %d", subArrayFirstItemIndex + 1, subArrayLastItemIndex + 1)
                : "not found!"
        );
    }
}
