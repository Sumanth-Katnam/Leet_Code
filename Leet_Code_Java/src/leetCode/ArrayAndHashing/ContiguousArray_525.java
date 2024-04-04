package leetCode.ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int count_0 = 0, count_1 = 0;
        Map<Integer, Integer> diff_map = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] == 0)
                count_0 += 1;
            else
                count_1 += 1;

//            if(!diff_map.containsKey(count_1 - count_0))
//                diff_map.put(count_1 - count_0, idx);
            diff_map.put(count_1 - count_0, diff_map.getOrDefault(count_1 - count_0, idx));

            if(count_0 == count_1)
                res = count_0 * 2;
            else
                res = Math.max(res, idx - diff_map.get(count_1 - count_0));
        }

        return res;
    }
}
