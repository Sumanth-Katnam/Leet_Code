package leetCode.Trees.Easy;


import helpers.TreeNodeMain.TreeNode;

public class BalancedBinaryTree_110 {
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(Math.abs(helper(root.left) - helper(root.right)) <= 1) return left && right;
        return false;
    }

    public static int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left) + 1;
        int right = helper(node.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
