package leetCode.Backtracking.Hard;

import java.util.*;

public class NQueens_51 {
    private void addBoard(List<List<String>> res, char[][] board){
        List<String> copy = new ArrayList<>();
        for(char[] row: board){
            copy.add(new String(row));
        }
        res.add(copy);
    }
    private void backtrack(List<List<String>> res, int rowNum, int n, char[][] board, Set<Integer> cols, Set<Integer> leftDiagonal, Set<Integer> rightDiagonal) {
        if(rowNum == n){
            addBoard(res, board);
        } else {
            for(int colNum = 0; colNum < n; colNum++){
                if(cols.contains(colNum)
                        || leftDiagonal.contains(rowNum + colNum)
                        || rightDiagonal.contains(rowNum - colNum)){
                    continue;
                } else {
                    cols.add(colNum);
                    leftDiagonal.add(rowNum + colNum);
                    rightDiagonal.add((rowNum - colNum));
                    board[rowNum][colNum] = 'Q';

                    backtrack(res, rowNum + 1, n, board, cols, leftDiagonal, rightDiagonal);

                    cols.remove(colNum);
                    leftDiagonal.remove(rowNum + colNum);
                    rightDiagonal.remove((rowNum - colNum));
                    board[rowNum][colNum] = '.';

                }
            }
        }


    }
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> leftDiagonal = new HashSet<>();
        Set<Integer> rightDiagonal = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        backtrack(res, 0, n, board, cols, leftDiagonal, rightDiagonal);
        return res;
    }
}
