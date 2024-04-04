package leetCode.ArrayAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

//        pre prod
        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            res[i] = prod;
            prod = prod * nums[i];
        }

//        post prod
        prod = 1;
        for(int i = nums.length - 1; i > -1; i--) {
            res[i] = res[i] * prod;
            prod = prod * nums[i];
        }

        return res;
    }
}
