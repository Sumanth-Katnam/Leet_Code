package leetCode.TwoPointers;

public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int zero_idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[zero_idx];
                nums[zero_idx] = nums[i];
                nums[i] = temp;
                zero_idx += 1;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
