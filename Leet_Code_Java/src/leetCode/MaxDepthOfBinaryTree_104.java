package leetCode;

import helpers.TreeNodeMain.TreeNode;

public class MaxDepthOfBinaryTree_104 {
    public static int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int currentDepth){
        if(node == null)
            return currentDepth;
        int leftDepth = helper(node.left, currentDepth + 1);
        int rightDepth = helper(node.right, currentDepth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {

    }
}
