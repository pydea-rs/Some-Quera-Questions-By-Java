import java.util.Scanner;

public class problem04 {

    public static int[] orderedSubArray(int[] arr, int start, int end) {
        final int L = end - start + 1;
        int[] result = new int[L];
        if(arr[start] <= arr[end])
            for (int i = 0; i < L; result[i] = arr[i++]);
        else
            for(int i = 0; i < L; result[i] = arr[end - i], i++);
        return result;
    }

    public static int freeArea(int[] columns, int rectLeftIndex, int rectRightIndex) {
        int area = 0;
        for(int i = rectLeftIndex + 1; i < rectRightIndex;
            area += columns[rectLeftIndex] - columns[i++]);
        return area;
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        final int N = input.nextInt();
        int[] heights = new int[N];
        for(int i = 0; i < N; heights[i] = input.nextInt(),  i++); // fill the heights array

        int maxWaterContainerArea = 0;
        for(int i = 0; i < N - 1; i++) {
            // first and last column behave as boundaries and dont contain any water
            // so the loop starts at 1 and ens in N-2 index of array
            heights = orderedSubArray(heights, i, N - 1);

            int j = i + 1;
            for(; j < heights.length && heights[i] >= heights[j]; j++);
            // now we have section that we can extract a rectangle, which is filled with some columns
            // the amount of water that can fill this rectangle, is the area of the rectangle - occupied heights
            maxWaterContainerArea += freeArea(heights, i, j);
            i = j - 1; // and right after, i++ makes this ;=> i = j
        }

        System.out.println(maxWaterContainerArea);
    }
}
