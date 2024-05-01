package leetCode.ArrayAndHashing.Easy;

import java.util.Arrays;

public class MissingNumber_268 {
    public int missingNumber_(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int target = n*(n + 1)/2;
        return target - Arrays.stream(nums).sum();
    }
}
