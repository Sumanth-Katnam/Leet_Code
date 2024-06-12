package leetCode.ArrayAndHashing.Medium;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, i = 0, temp;
        while(l < r){
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            } else if(nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                i--;
                r--;
            }
            i++;
        }
    }
}
