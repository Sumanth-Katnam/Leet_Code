package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int num : nums){
            if (nums[Math.abs(num) - 1] < 0)
                res.add(Math.abs(num));
            nums[Math.abs(num) - 1] *= -1;
        }

        return res;
    }
}
