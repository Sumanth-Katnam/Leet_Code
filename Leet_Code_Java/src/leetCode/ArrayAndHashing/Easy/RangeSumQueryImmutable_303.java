package leetCode.ArrayAndHashing.Easy;

public class RangeSumQueryImmutable_303 {
    int[] nums;
//    Since the class name is not the same, changed constructor to a method
    public void NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++)
            nums[i] += nums[i-1];
        this.nums=nums;
    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return this.nums[right];

        return this.nums[right] - this.nums[left - 1];
    }
}
