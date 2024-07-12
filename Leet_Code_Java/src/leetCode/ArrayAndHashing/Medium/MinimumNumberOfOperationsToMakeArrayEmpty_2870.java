package leetCode.ArrayAndHashing.Medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty_2870 {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num: nums){
            cntMap.merge(num, 1, Integer::sum);
        }

        int res = 0;
        for(int num: cntMap.keySet()){
            if(cntMap.get(num) == 1) return -1;

            res += Math.floorDiv(cntMap.get(num), 3);
            if(cntMap.get(num) % 3 > 0){
                res++;
            }
        }
        return res;
    }
}
