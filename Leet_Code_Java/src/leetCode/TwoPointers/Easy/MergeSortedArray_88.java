package leetCode.TwoPointers.Easy;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = n + m - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[last] = nums2[n - 1];
                n--;
            } else {
                nums1[last] = nums1[m - 1];
                m--;
            }
            last--;
        }

        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }

    }
}
