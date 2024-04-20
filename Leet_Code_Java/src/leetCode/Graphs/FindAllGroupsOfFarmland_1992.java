package leetCode.Graphs;

import java.util.*;

public class FindAllGroupsOfFarmland_1992 {
    private List<Integer> bfs(int r, int c,int[][] land, int ROWS, int COLS){
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };
        Queue<List<Integer>> dq = new ArrayDeque<>();
        dq.add(List.of(r, c));
        land[r][c] = -1;
        List<Integer> last_point = List.of(-1, -1);
        int x, y;
        while(!dq.isEmpty()){
            int dq_len = dq.size();

            for(int i = 0; i < dq_len; i++){
                last_point = dq.poll();

                for(int j = 0; j < 4; j++){
                    x = last_point.get(0) + dirs[j][0];
                    y = last_point.get(1) + dirs[j][1];

                    if (0 <= x  && x < ROWS
                    && 0 <= y && y <COLS
                    && land[x][y] == 1){
                        dq.add(List.of(x, y));
                        land[x][y] = -1;
                    }
                }
            }
        }
        return last_point;
    }

    public int[][] findFarmland(int[][] land) {
        int ROWS = land.length, COLS = land[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(land[r][c] == 1){
                    List<Integer> co_ord = new ArrayList<>();
                    co_ord.add(r);
                    co_ord.add(c);
                    co_ord.addAll(bfs(r, c, land, ROWS, COLS));
                    res.add(co_ord);
                }
            }
        }
        return res.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
