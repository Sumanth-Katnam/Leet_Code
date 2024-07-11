package leetCode.ArrayAndHashing.Medium;

public class MinimumAdjacentSwapsToMakeAValidArray_2340 {
    public static int minimumSwaps(int[] nums) {
        int maxInd = 0, minInd = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums[minInd]) minInd = i;
            else if(nums[i] >= nums[maxInd]) maxInd = i;
        }
        if(minInd == maxInd) return 0;
        if(minInd < maxInd) return minInd + nums.length - 1 - maxInd;
        else return nums.length - 2 +  minInd - maxInd;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[] {3,4,5,5,3,1})); //6
        System.out.println(minimumSwaps(new int[] {9})); //0
    }
}
