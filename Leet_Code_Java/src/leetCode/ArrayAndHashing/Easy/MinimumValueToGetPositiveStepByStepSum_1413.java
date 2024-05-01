package leetCode.ArrayAndHashing.Easy;

public class MinimumValueToGetPositiveStepByStepSum_1413 {
    public int minStartValue(int[] nums) {
        long min_val = Long.MAX_VALUE, pre_sum =  0;

        for(int num : nums){
            pre_sum += num;
            if(min_val > pre_sum)
                min_val = pre_sum;
        }

        return min_val >= 1 ? 1 : (int) (Math.abs(min_val) + 1);
    }
}
