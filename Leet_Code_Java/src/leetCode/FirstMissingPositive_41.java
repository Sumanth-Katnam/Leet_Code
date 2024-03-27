package leetCode;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int num_len = nums.length;
        // changing all negatives to zero
        for(int i = 0; i < num_len; i++){
            if(nums[i] < 0)
                nums[i] = 0;
        }

        int val;
        // Marking if a value exists
        for(int i = 0; i < num_len; i++){
            val = Math.abs(nums[i]);
            if (1 <= val && val <= num_len){
                if(nums[val - 1] > 0)
                    nums[val - 1] *= -1;
                else if (nums[val - 1] == 0)
                    nums[val - 1] = -1 * (num_len + 1);
            }
        }

        // Finding the missing num
        for(int i = 1; i <= num_len; i++) {
            if(nums[i - 1] >= 0)
                return i;
        }
        return num_len + 1;
    }
}
