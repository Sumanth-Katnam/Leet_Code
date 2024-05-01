package leetCode.Trees.Easy;


import helpers.TreeNodeMain;
import helpers.TreeNodeMain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !treeNodeStack.empty()){
            while(curr != null){
                treeNodeStack.push(curr);
                curr = curr.left;
            }
            curr = treeNodeStack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;

//        Threaded Binary Tree --- Morrison method
//        List < Integer > res = new ArrayList < > ();
//        TreeNode curr = root;
//        TreeNode pre;
//        while (curr != null) {
//            if (curr.left == null) {
//                res.add(curr.val);
//                curr = curr.right; // move to next right node
//            } else { // has a left subtree
//                pre = curr.left;
//                while (pre.right != null) { // find rightmost
//                    pre = pre.right;
//                }
//                pre.right = curr; // put cur after the pre node
//                TreeNode temp = curr; // store cur node
//                curr = curr.left; // move cur to the top of the new tree
//                temp.left = null; // original cur left be null, avoid infinite loops
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeMain.populateTree(List.of(new Integer[]{1, 0, 2, 3}));
        for (Integer ele : inorderTraversal(root)) {
            System.out.println(ele);
        }
    }
}
