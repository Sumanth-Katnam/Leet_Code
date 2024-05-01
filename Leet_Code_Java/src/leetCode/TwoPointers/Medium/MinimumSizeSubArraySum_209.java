package leetCode.TwoPointers.Medium;

public class MinimumSizeSubArraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int i = 0, curr_sum = 0;

        for(int j = 0; j < nums.length; j++){
            curr_sum += nums[j];
            while(curr_sum >= target){
                res = Math.min(res, j - i + 1);
                curr_sum -= nums[i];
                i++;
            }

        }

        return res == nums.length + 1? 0 : res;
    }
}
