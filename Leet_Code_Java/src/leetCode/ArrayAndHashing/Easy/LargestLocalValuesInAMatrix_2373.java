package leetCode.ArrayAndHashing.Easy;

public class LargestLocalValuesInAMatrix_2373 {
    private int getLargestLocal(int[][] grid, int r, int c) {
        int maxVal = 0;

        for (int i = r ; i < r+3 ; i++) {
            for (int j = c ; j < c+3 ; j++) {
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }

        return maxVal;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int m = n-2;

        int[][] ans = new int[m][m];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < m ; j++) {
                ans[i][j] = getLargestLocal(grid, i, j);
            }
        }

        return ans;
    }
}
