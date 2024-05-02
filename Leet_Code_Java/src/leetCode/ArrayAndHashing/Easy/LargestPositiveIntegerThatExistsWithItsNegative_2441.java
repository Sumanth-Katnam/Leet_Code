package leetCode.ArrayAndHashing.Easy;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative_2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int res = -1;

        for(int num : nums){
            if(seen.contains(-1 * num)){
                res = Math.max(res, Math.abs(num));
            }
            seen.add(num);
        }
        return res;
    }
}
