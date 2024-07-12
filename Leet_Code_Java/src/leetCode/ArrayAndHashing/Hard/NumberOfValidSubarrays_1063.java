package leetCode.ArrayAndHashing.Hard;

public class NumberOfValidSubarrays_1063 {
    public static int validSubarrays(int[] nums) {
        int res = nums.length;
        for(int i = 0; i< nums.length; i++){
            int j = i + 1;
            while(j < nums.length && nums[i] <= nums[j]){
                j++;
            }
            res += (j - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(validSubarrays(new int[] {1,4,2,5,3})); //11
        System.out.println(validSubarrays(new int[] {3,2,1})); //3
        System.out.println(validSubarrays(new int[] {2,2,2})); //6
    }
}
