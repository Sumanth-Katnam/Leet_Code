package leetCode.BitManipulation;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK_2997 {
    public int minOperations(int[] nums, int k) {
        int xor = nums[0];

        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }

        xor ^= k;

        int res = 0;
        while(xor > 0){
            res++;
            xor &= xor - 1;
        }

        return res;
    }
}
