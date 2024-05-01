package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;

public class SumRootToLeafNumbers_129 {
    private int res = 0;
    private void dfs(TreeNode node, int num){
        num = num * 10 + node.val;
        if(node.left == null && node.right == null){
            res += num;
        } else {
            if(node.left != null)
                dfs(node.left, num);
            if(node.right != null)
                dfs(node.right, num);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}
