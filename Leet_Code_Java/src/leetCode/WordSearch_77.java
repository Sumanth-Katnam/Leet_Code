package leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordSearch_77 {
    static Map<Integer, int[]> skipMap = new HashMap<>();
    public static boolean exist(char[][] board, String word) {
        if(word.length() > board.length * board[0].length)
            return false;

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
                } else if(!word.contains(String.valueOf(board[i][j])))
                    addSkipEntry(i, j);
            }
        }

        if(!letterFound)
            return false;

        boolean isFound = false;
        if(word.length() == 1)
            return firstLetterPos.size() > 0;

        for (Map.Entry<Integer, Integer> posTuple : firstLetterPos) {
            int i = posTuple.getKey();
            int j = posTuple.getValue();
            if(!isFound)
                isFound = helper(board, word, 0, i, j);
        }

        return isFound;
    }

    public static boolean helper(char[][] board, String word, int letterIndex, int rowIndex, int colIndex) {
        if(!isValidPos(board, rowIndex, colIndex))
            return false;

        int[] skipRowArr = skipMap.get(rowIndex);

        if(IntStream.of(skipRowArr).noneMatch(x -> x == colIndex)){
            if(letterIndex == word.length() - 1)
                return board[rowIndex][colIndex] == word.charAt(letterIndex);

            boolean isFound = false;
            addSkipEntry(rowIndex, colIndex);
            if(word.charAt(letterIndex) == board[rowIndex][colIndex]){
                isFound = helper(board, word, letterIndex + 1, rowIndex + 1, colIndex)
                        || helper(board, word, letterIndex + 1, rowIndex - 1, colIndex)
                        || helper(board, word, letterIndex + 1, rowIndex, colIndex + 1)
                        || helper(board, word, letterIndex + 1, rowIndex, colIndex - 1);
            }

            if(!isFound){
                removeSkipEntry(rowIndex, colIndex);
                return false;
            } else {
                return true;
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

    public static void removeSkipEntry(int rowIndex, int colIndex){
        int[] skipRowArr = skipMap.get(rowIndex);
        List<Integer> skipRowList = Arrays.stream(skipRowArr).boxed().collect(Collectors.toList());
        skipRowList.remove(Integer.valueOf(colIndex));
        skipMap.put(rowIndex, skipRowList.stream().mapToInt(i -> i).toArray());
    }

    public static boolean isValidPos(char[][] board, int rowIndex, int colIndex){
        return rowIndex >= 0
                && rowIndex < board.length
                && colIndex >= 0
                && colIndex < board[rowIndex].length;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'} ,{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'} ,{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        System.out.println(exist(new char[][]{{'A'}}, "A"));
        System.out.println(exist(new char[][]{{'A', 'A'}}, "AA"));
        System.out.println(exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "DBAC"));
        System.out.println(exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "CDBA"));
        System.out.println(exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
        System.out.println(exist(new char[][]{{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}}, "AAAAAAAAAAAAA"));
    }
}
