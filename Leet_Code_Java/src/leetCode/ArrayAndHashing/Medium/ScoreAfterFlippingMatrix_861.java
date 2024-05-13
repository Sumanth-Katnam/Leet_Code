package leetCode.ArrayAndHashing.Medium;

import java.util.HashMap;
import java.util.Map;

public class ScoreAfterFlippingMatrix_861 {
    public int matrixScore(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Map<Integer, Integer> oneCntMap = new HashMap<>();

        for(int r = 0; r < ROWS; r++){
            if(grid[r][0] == 0){
                for(int c = 0; c < COLS; c++){
                    grid[r][c] = grid[r][c] == 1? 0: 1;
                }
            }
        }
        int oneCnt;
        for(int c = 0; c < COLS; c++){
            oneCnt = 0;
            for (int[] row : grid) {
                if (row[c] == 1) oneCnt++;
            }
            oneCntMap.put(c, Math.max(oneCnt, ROWS - oneCnt));
        }
        int posPow = 1;
        int res = 0;
        for(int c = COLS - 1; c > -1; c--){
            res += oneCntMap.get(c) * posPow;
            posPow *= 2;
        }
        return res;
    }
}
