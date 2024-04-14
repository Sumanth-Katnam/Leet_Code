package leetCode.Trees;

import helpers.TreeNodeMain.TreeNode;

public class SumOfLeftLeaves_404 {
    private int dfs(TreeNode node, boolean isLeft){
        if(node == null)
            return 0;

        if(node.left == null && node.right == null && isLeft)
            return node.val;

        return dfs(node.left, true) + dfs(node.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
}
