package leetCode.ArrayAndHashing.Easy;

public class RunningSumOf1dArray_1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int running_sum = 0;

        for(int i = 0; i< nums.length; i++){
            running_sum += nums[i];
            res[i] = running_sum;
        }

        return res;
    }
}
