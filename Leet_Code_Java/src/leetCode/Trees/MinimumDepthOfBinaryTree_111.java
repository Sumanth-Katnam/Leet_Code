package leetCode.Trees;

import helpers.TreeNodeMain.TreeNode;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        return helper(root, 1, Integer.MAX_VALUE);
    }

    public int helper(TreeNode node, int depth, int leastNow) {
        if(node == null) return 0;
        if(node.left == null || node.right == null) return Math.min(depth, leastNow);
        int left = helper(node.left, depth + 1, leastNow);
        int right = helper(node.right, depth + 1, leastNow);
        return Math.min(left, right);
    }

    public static void main(String[] args) {

    }
}
