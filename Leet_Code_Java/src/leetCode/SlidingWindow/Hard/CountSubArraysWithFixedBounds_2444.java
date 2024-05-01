package leetCode.SlidingWindow.Hard;

public class CountSubArraysWithFixedBounds_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = 0;
        int min_idx = 0, max_idx = 0;
        boolean min_found = false, max_found = false;
        long res = 0;

        for(int idx = 0; idx < nums.length; idx++){
            if (nums[idx] == minK){
                min_found = true;
                min_idx = idx;
            }

            if(nums[idx] == maxK){
                max_found = true;
                max_idx = idx;
            }

            if(nums[idx] < minK || nums[idx] > maxK){
                min_found = max_found = false;
                start = idx + 1;
            } else if(min_found && max_found)
                res += Math.min(min_idx, max_idx) - start + 1;
        }
        return res;
    }
}
