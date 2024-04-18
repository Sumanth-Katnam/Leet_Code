package leetCode.Graphs;

public class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    res += 4;

                    if(r > 0 && grid[r - 1][c] == 1)
                        res -= 2;

                    if(c > 0 && grid[r][c - 1] == 1)
                        res -= 2;
                }
            }
        }
        return res;
    }
}
