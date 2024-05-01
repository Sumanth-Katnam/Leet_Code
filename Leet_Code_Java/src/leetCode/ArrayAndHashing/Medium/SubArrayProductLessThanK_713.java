package leetCode.ArrayAndHashing.Medium;

public class SubArrayProductLessThanK_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, l = 0, prod = 1;

        for(int r = 0; r < nums.length; r++){
            prod *= nums[r];

            while(prod >= k && l <= r){
                prod = prod /nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
