package leetCode.ArrayAndHashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK_2006 {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int res = 0;
        for(int num: nums){
            res += cntMap.getOrDefault(num + k, 0) + cntMap.getOrDefault(num - k, 0);
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
