package leetCode.Trees;

import helpers.TreeNodeMain.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrToBST_108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left , int right){
        int middle = (left + right) / 2;
        if(left <= right){
            return new TreeNode(nums[middle], helper(nums, left, middle - 1), helper(nums, middle + 1, right));
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
