package leetCode.Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOrangeCnt = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    freshOrangeCnt++;
                }
            }
        }
        if (freshOrangeCnt == 0)
            return 0;

        if (q.isEmpty())
            return -1;

        int mins = -1;
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < ROWS && j >= 0 && j < COLS && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        freshOrangeCnt--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            mins++;
        }

        if (freshOrangeCnt == 0)
            return mins;
        return -1;
    }
}
