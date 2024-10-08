package leetCode.Greedy.Medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509 {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int diff;
        for(int i = 0; i < 4; i++){
            diff = nums[nums.length - 4 + i] - nums[i];
            res = Math.min(res, diff);
        }
        return res;
    }
}
