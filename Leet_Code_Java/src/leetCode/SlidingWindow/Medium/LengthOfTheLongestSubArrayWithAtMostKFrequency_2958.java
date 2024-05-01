package leetCode.SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfTheLongestSubArrayWithAtMostKFrequency_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0, res = 0;
        Map<Integer, Integer> cnt_map = new HashMap<>();

        for(int r = 0; r < nums.length; r++){
            cnt_map.put(nums[r], cnt_map.getOrDefault(nums[r], 0) + 1);

            while(cnt_map.get(nums[r]) > k){
                cnt_map.put(nums[l], cnt_map.get(nums[l]) - 1);
                l++;
            }
            res = Math.max(res, r -l + 1);
        }
        return res;
    }
}
