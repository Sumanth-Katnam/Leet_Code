package leetCode.Greedy.Hard;

import java.util.Arrays;
import java.util.Collections;

public class FindTheMaximumSumOfNodeValues_3068 {
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int numsLen = nums.length;
        Integer[] diff = new Integer[numsLen];

        for (int i = 0; i < numsLen; i++){
            diff[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        long res = Arrays.stream(nums).asLongStream().sum();
        int adjSum;
        for(int i = 0; i < numsLen - 1; i += 2){
            adjSum = diff[i] + diff[i + 1];
            if (adjSum > 0)
                res += adjSum;
        }
        return res;
//        long res = 0;
//        int minDiff = Integer.MAX_VALUE, evenNegativeDiffFlag = 0;
//        for (int num : nums) {
//            int xorVal = num ^ k;
//            res += Math.max(num, xorVal);
//            evenNegativeDiffFlag ^= num < xorVal ? 1 : 0;
//            minDiff = Math.min(minDiff, Math.abs(num - xorVal));
//        }
//        return res - minDiff * evenNegativeDiffFlag;
    }

    public static void main(String[] args) {
        System.out.println(maximumValueSum(new int[]{1,2,1}, 3, new int[][]{{0, 1}, {0, 2}}));
    }
}
