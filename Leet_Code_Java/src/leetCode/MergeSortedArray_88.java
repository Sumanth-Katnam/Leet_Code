package leetCode;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (m < nums1.length){
            nums1[m] = nums2[i];
            i++;
            m++;
        }
        Arrays.sort(nums1);

        for (int ele : nums1) {
            System.out.println(ele);
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
