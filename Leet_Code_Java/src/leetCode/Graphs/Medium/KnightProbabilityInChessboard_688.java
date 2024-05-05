package leetCode.Graphs.Medium;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessboard_688 {
    private final int[][] moves = new int[][]{
        {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}
    };
    private double dfs(int r, int c, int n, Map<String, Double> visited, int k){
        if(k < 0)
            return 1;

        String key = r + "_" + c + "_" + k;
        if(visited.containsKey(key))
            return visited.get(key);

        double res = 0;
        for(int[] move: moves){
            if(r >= 0 && r < n && c >= 0 && c < n)
                res += dfs(r + move[0], c + move[1], n, visited, k - 1);
        }
        visited.put(key, res/8.0);
        return res/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        return dfs(row, column, n, new HashMap<>(), k)/(Math.pow(8, k));
    }
}
