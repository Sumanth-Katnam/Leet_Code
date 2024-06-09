package leetCode.ArrayAndHashing.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remCntMap = new HashMap<>();
        remCntMap.put(0, 1);

        int currSum = 0, res = 0, rem;
        for(int num: nums){
            currSum += num;
            rem = currSum % k;

            if(rem < 0) rem += k;

            if(remCntMap.containsKey(rem))
                res += remCntMap.get(rem);

            remCntMap.put(rem, remCntMap.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
