package leetCode;

import helpers.TreeNodeMain;
import helpers.TreeNodeMain.TreeNode;

import java.util.List;

public class SymmetricTree_101 {
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSymmetric(p.right, q.left) &&
                isSymmetric(p.left, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeNodeMain.populateTree(List.of(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
        System.out.println(isSymmetric(p));
    }
}
