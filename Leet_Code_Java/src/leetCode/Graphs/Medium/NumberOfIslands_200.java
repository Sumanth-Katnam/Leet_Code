package leetCode.Graphs.Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands_200 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void bfs(char[][] grid, int r, int c, int ROWS, int COLS){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        grid[r][c] = '2';

        int[] pop_pos;
        int x, y;
        while(!q.isEmpty()){
            pop_pos = q.poll();
            for(int i = 0; i < 4; i++){
                x = pop_pos[0] + dirs[i][0];
                y = pop_pos[1] + dirs[i][1];

                if ((0 <= x && x <= ROWS - 1)
                && (0 <= y && y <= COLS - 1)
                && grid[x][y] == '1'){
                    q.add(new int[]{x, y});
                    grid[x][y] = '2';
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    bfs(grid, r, c, ROWS, COLS);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }
}
