package leetCode.ArrayAndHashing.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);

        int currSum = 0, rem;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            rem = currSum % k;
            if(remainderMap.containsKey(rem)){
                if(i - remainderMap.get(rem) > 1){
                    return true;
                }
            } else{
                remainderMap.put(rem, i);
            }
        }
        return false;
    }
}
