package leetCode.Trees.Easy;

import helpers.TreeNodeMain.TreeNode;

public class EvaluateBooleanBinaryTree_2331 {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1 || root.val == 0)
            return root.val == 1;
        else if(root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        else
            return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
