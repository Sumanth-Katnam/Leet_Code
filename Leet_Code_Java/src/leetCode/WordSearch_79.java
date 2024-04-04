package leetCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordSearch_79 {
    public boolean dfs(char[][] board, int[][] visited, String word,
                       int i, int r, int c, int r_max, int c_max){
        if(i == word.length())
            return true;

        if (r < 0 || c < 0
        || r >= r_max || c >= c_max
        || word.charAt(i) != board[r][c]
        || visited[r][c] == 1)
            return false;

        visited[r][c] = 1;
        boolean res = (dfs(board, visited, word, i + 1, r - 1, c, r_max, c_max)
        || dfs(board, visited, word,i + 1, r + 1, c, r_max, c_max)
        || dfs(board, visited, word,i + 1, r, c - 1, r_max, c_max)
        || dfs(board, visited, word,i + 1, r, c + 1, r_max, c_max));
        visited[r][c] = 0;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int r_max = board.length;
        int c_max = board[0].length;
        int[][] visited = new int[r_max][c_max];

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(board, visited, word, 0, i, j, r_max, c_max))
                    return true;
            }
        }
        return false;
    }
}
