package leetCode.DP2.Hard;

import java.util.Arrays;

public class MinimumFallingPathSumII_1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] prev_row = grid[0];

        int temp;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                temp = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(j != k){
                        temp = Math.min(temp, grid[i][j] + prev_row[k]);
                    }
                }
                grid[i][j] = temp;
            }
            prev_row = grid[i];
        }
        return Arrays.stream(prev_row).min().getAsInt();
    }
}
