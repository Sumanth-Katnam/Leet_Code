package leetCode.ArrayAndHashing.Easy;

import java.util.Arrays;

public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(i -> i * i).sorted().toArray();
    }
}
