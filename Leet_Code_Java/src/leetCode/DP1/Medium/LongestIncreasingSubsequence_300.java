package leetCode.DP1.Medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for(int i = nums.length - 1; i > -1; i--)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] < nums[j])
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);

        return Arrays.stream(LIS).max().getAsInt();
    }
}
