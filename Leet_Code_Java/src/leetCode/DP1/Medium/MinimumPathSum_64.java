package leetCode.DP1.Medium;

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[] prevRow = grid[ROWS - 1];

        for(int idx = COLS - 2; idx > -1; idx--){
            prevRow[idx] += prevRow[idx + 1];
        }
        int[] currRow;
        for(int r = ROWS - 2; r > -1; r--){
            currRow = grid[r];
            for(int c = COLS - 1; c > -1; c--){
                currRow[c] += Math.min(prevRow[c], c + 1 < COLS? currRow[c + 1] : Integer.MAX_VALUE);
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }
}
