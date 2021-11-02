package leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordSearch_77 {
    static Map<Integer, int[]> skipMap = new HashMap<>();
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            skipMap.put(i, new int[]{});
        }

        boolean letterFound = false;
        List<Map.Entry<Integer, Integer>> firstLetterPos = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    letterFound = true;
                    firstLetterPos.add(new AbstractMap.SimpleEntry<>(i, j));
                    continue;
                }
                if(!word.contains(String.valueOf(board[i][j])))
                    addSkipEntry(i, j);
            }
        }

        if(!letterFound)
            return false;

        boolean isFound = false;
        if(word.length() == 1)
            return firstLetterPos.size() > 0;

        int prev_i, prevj;
        for (Map.Entry<Integer, Integer> posTuple : firstLetterPos) {
            int i = posTuple.getKey();
            int j = posTuple.getValue();
            addSkipEntry(i, j);
            if(!isFound)
                isFound = helper(board, word, 1, i + 1, j)
                        || helper(board, word, 1, i, j + 1)
                        || helper(board, word, 1, i, j - 1)
                        || helper(board, word, 1, i - 1, j);
        }

        return isFound;
    }

    public static boolean helper(char[][] board, String word, int letterIndex, int rowIndex, int colIndex) {
        if(!isValidPos(board, rowIndex, colIndex))
            return false;

        int[] skipRowArr = skipMap.get(rowIndex);

        if(IntStream.of(skipRowArr).noneMatch(x -> x == colIndex)){
            addSkipEntry(rowIndex, colIndex);
            if(letterIndex == word.length() - 1){
                return board[rowIndex][colIndex] == word.charAt(letterIndex);
            }

            if(word.charAt(letterIndex) == board[rowIndex][colIndex]){
                return helper(board, word, letterIndex + 1, rowIndex + 1, colIndex)
                        || helper(board, word, letterIndex + 1, rowIndex, colIndex + 1)
                        || helper(board, word, letterIndex + 1, rowIndex, colIndex - 1)
                        || helper(board, word, letterIndex + 1, rowIndex - 1, colIndex);
            }
        }
        return false;
    }

    public static void addSkipEntry(int rowIndex, int colIndex){
        int[] skipRowArr = skipMap.get(rowIndex);
        List<Integer> skipRowList = Arrays.stream(skipRowArr).boxed().collect(Collectors.toList());
        skipRowList.add(colIndex);
        skipMap.put(rowIndex, skipRowList.stream().mapToInt(i -> i).toArray());
    }

    public static boolean isValidPos(char[][] board, int rowIndex, int colIndex){
        return rowIndex >= 0
                && rowIndex < board.length
                && colIndex >= 0
                && colIndex < board[rowIndex].length;
    }

    public static void main(String[] args) {
//        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
//        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'} ,{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
//        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'} ,{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
//        System.out.println(exist(new char[][]{{'A'}}, "A"));
        System.out.println(exist(new char[][]{{'A', 'A'}}, "AA"));
    }
}
