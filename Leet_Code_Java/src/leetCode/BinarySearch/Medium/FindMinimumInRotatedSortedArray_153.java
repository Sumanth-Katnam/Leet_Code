package leetCode.BinarySearch.Medium;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int res = nums[0];
        int l = 0, r = nums.length - 1;

        int m;
        while(l <= r){
            if(nums[l] <= nums[r])
                return Math.min(nums[l], res);

            m = (l + r)/2;

            res = Math.min(res, nums[m]);

            if(nums[m] >= nums[l])
                l = m + 1;
            else
                r = m - 1;
        }
        return res;
    }
}
