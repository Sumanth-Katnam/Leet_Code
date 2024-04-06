package leetCode.ArrayAndHashing;

public class RangeSumQueryImmutable_303 {
    int[] nums;
    public NumArray(int[] nums) {
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
