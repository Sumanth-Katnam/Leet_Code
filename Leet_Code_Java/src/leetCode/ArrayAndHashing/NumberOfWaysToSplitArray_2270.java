package leetCode.ArrayAndHashing;

import java.util.Arrays;

public class NumberOfWaysToSplitArray_2270 {
    public int waysToSplitArray(int[] nums) {
        long tot_sum = 0;
        for(int num : nums){
            tot_sum += num;
        }
        long left_sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            left_sum += nums[i];
            tot_sum -= nums[i];
            if(left_sum >= tot_sum)
                res++;
        }
        return res;
    }
}
