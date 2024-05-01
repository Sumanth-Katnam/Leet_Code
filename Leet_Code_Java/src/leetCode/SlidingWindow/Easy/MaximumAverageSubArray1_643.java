package leetCode.SlidingWindow.Easy;

import java.util.Arrays;

public class MaximumAverageSubArray1_643 {
    public double findMaxAverage(int[] nums, int k) {
        int cur = Arrays.stream(nums, 0, k).sum();
        int res = cur;

        for(int i = k; i < nums.length; i++){
            cur += nums[i] - nums[i-k];
            if(cur > res)
                res = cur;
        }

        return (double) res /k;
    }
}
