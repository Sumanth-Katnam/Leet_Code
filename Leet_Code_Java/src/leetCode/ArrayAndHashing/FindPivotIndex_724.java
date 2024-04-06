package leetCode.ArrayAndHashing;

import java.util.Arrays;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int left = 0, right = Arrays.stream(nums).sum();

        for(int idx = 0; idx < nums.length; idx++){
            right -= nums[idx];
            if(left == right)
                return idx;
            left += nums[idx];
        }
        return -1;
    }
}
