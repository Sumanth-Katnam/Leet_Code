package leetCode.Trees.Easy;

import helpers.TreeNodeMain;
import helpers.TreeNodeMain.TreeNode;

import java.util.List;

public class SameTree_100 {
    public static boolean isSameTree(TreeNodeMain.TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {    
        TreeNode p = TreeNodeMain.populateTree(List.of(new Integer[]{1, 2, 3}));
        TreeNode q = TreeNodeMain.populateTree(List.of(new Integer[]{1, 2, 3}));
        System.out.println(isSameTree(p, q));
    }
}
