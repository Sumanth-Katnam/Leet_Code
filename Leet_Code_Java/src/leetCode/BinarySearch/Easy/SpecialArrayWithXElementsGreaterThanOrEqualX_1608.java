package leetCode.BinarySearch.Easy;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX_1608 {
    private int binSearch(int[] nums, int n, int curNum) {
        int left = 0, right = n - 1;
        int firstIndex = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= curNum) {
                firstIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - firstIndex;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int num = 1; num <= n; ++num) {
            if (num == binSearch(nums, n, num)) {
                return num;
            }
        }
        return -1;
    }
}
