package leetCode.Graphs.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RegionsCutBySlashes_959 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] enhancedGrid;
    private static int newN;
    private static void bfs(int r, int c){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r, c});
        enhancedGrid[r][c] = -1;
        int x, y;
        while(!dq.isEmpty()){
            int[] poppedVals = dq.pollFirst();
            for(int i = 0; i < 4; i++){
                x = poppedVals[0] + dirs[i][0];
                y = poppedVals[1] + dirs[i][1];

                if ((0 <= x && x <= newN - 1)
                        && (0 <= y && y <= newN - 1)
                        && enhancedGrid[x][y] == 0){
                    enhancedGrid[x][y] = -1;
                    dq.add(new int[]{x, y});
                }
            }
        }
    }
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        newN = n * 3;
        enhancedGrid = new int[newN][newN];

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int new_r = r * 3, new_c = c * 3;
                if(grid[r].charAt(c) == '/'){
                    enhancedGrid[new_r][new_c + 2] = 1;
                    enhancedGrid[new_r + 1][new_c + 1] = 1;
                    enhancedGrid[new_r + 2][new_c] = 1;
                } else if(grid[r].charAt(c) == '\\'){
                    enhancedGrid[new_r][new_c] = 1;
                    enhancedGrid[new_r + 1][new_c + 1] = 1;
                    enhancedGrid[new_r + 2][new_c + 2] = 1;
                }
            }
        }

        int res = 0;
        for(int r = 0; r < newN; r++){
            for(int c = 0; c < newN; c++){
                if(enhancedGrid[r][c] == 0){
                    bfs(r, c);
                    res++;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{" /", "/ "}));
    }
}
