package leetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegers_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostN(nums, k) - atMostN(nums, k - 1);
    }
    public int atMostN(int[] nums, int n){
        Map<Integer, Integer> cnt_map = new HashMap<>();

        int l = 0, res = 0;

        for(int r = 0; r < nums.length; r++){
            cnt_map.put(nums[r], cnt_map.getOrDefault(nums[r], 0) + 1);

            while(cnt_map.size() > n){
                cnt_map.put(nums[l], cnt_map.get(nums[l]) - 1);
                if(cnt_map.get(nums[l]) == 0)
                    cnt_map.remove(nums[l]);

                l += 1;
            }
            res += r - l + 1;
        }
        return res;
    }
}
