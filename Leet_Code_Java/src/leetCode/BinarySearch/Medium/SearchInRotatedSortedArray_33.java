package leetCode.BinarySearch.Medium;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;
        while(l <= r){
            m = (l + r)/2;

            if(nums[m] == target)
                return m;

            // if left is increasing
            if(nums[m] >= nums[l])
                // if target not in left sub
                if(target > nums[m] || target < nums[l])
                    l = m + 1;
                else
                    r = m - 1;
            else
                // if not in right sub
                if(target < nums[m] || target > nums[r])
                    r = m - 1;
                else
                    l = m + 1;
        }
        return -1;
    }
}
