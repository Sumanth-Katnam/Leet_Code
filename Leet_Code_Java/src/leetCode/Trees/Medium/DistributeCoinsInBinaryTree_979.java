package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;

public class DistributeCoinsInBinaryTree_979 {
    private int dfs(TreeNode node, TreeNode parent){
        if(node == null) return 0;

        int moves = dfs(node.left, node) + dfs(node.right, node);
        int curr_val = node.val - 1;
        if(parent != null) parent.val += curr_val;
        moves += Math.abs(curr_val);
        return moves;
    }
    public int distributeCoins(TreeNode root) {
        return dfs(root, null);
    }
}
