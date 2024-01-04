package Spiral2DArray;

import java.util.Scanner;

public class Main {

    public static void fillArrayInSpiralOrder(int[][] arr) {
        for (int i = 0, value = 1; i < arr.length / 2; i++) {
            int size = (arr.length - i * 2 - 1);
            for (int j = 0, square = j / size,
                 sIndex = j % size, offset = arr.length - i - 1;
                 j < 4 * size;
                 j++, square = j / size, sIndex = j % size, offset = arr.length - i - 1)
            {

                if(square == 0)
                        arr[i][sIndex + i] = value;
                else if(square == 1)
                        arr[sIndex + i][offset] = value;
                else if(square == 2)
                        arr[offset][offset - sIndex] = value;
                else if(square == 3)
                        arr[offset - sIndex][i] = value;
                value++;
            }
            if (arr.length % 2 == 1)
                arr[arr.length/2][arr.length/2] = arr.length * arr.length;
        }
    }

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int[][] arr = new int[N][N];
        fillArrayInSpiralOrder(arr);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.printf("%d\t", arr[i][j]);
            System.out.println();
        }
    }
}
