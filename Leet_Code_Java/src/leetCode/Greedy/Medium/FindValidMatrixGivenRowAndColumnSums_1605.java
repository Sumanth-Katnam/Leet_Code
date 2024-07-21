package leetCode.Greedy.Medium;

import java.util.Arrays;

public class FindValidMatrixGivenRowAndColumnSums_1605 {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int ROWS = rowSum.length;
        int COLS = colSum.length;
        int[][] res = new int[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                int num = Math.min(rowSum[r], colSum[c]);
                rowSum[r] -= num;
                colSum[c] -= num;
                res[r][c] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(restoreMatrix(new int[]{3, 8}, new int[]{4, 7})));
        System.out.println(Arrays.deepToString(restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8})));
    }
}
