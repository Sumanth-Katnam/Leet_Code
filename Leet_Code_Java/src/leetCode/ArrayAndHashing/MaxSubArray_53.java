package leetCode.ArrayAndHashing;

public class MaxSubArray_53 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxTillNow = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max + nums[i], nums[i]);
            maxTillNow = Math.max(maxTillNow, max);
        }
        return maxTillNow;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
