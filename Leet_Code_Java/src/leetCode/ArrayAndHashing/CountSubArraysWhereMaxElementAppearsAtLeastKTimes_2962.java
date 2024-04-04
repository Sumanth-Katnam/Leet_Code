package leetCode.ArrayAndHashing;

import java.util.Arrays;

public class CountSubArraysWhereMaxElementAppearsAtLeastKTimes_2962 {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int l = 0;
        int max_ele = 0;
        for (int num : nums) {
            max_ele = Math.max(max_ele, num);
        }
        int max_cnt = 0;

        for (int num : nums) {
            if (num == max_ele)
                max_cnt++;

            while (max_cnt >= k) {
                if (nums[l] == max_ele)
                    max_cnt--;
                l++;
            }
            res += l;
        }

        return res;
    }
}
