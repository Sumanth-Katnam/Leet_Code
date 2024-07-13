package leetCode.Trees.Medium;

import helpers.TreeNodeMain;
import helpers.TreeNodeMain.TreeNode;

import java.util.*;

public class BoundaryOfBinaryTree_545 {
//    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        List<Integer> leaves = new ArrayList<>();
//        List<Integer> rightMost = new ArrayList<>();
//        Deque<TreeNode> dq = new ArrayDeque<>();
//        dq.offer(root);
//        int level = 0;
//        while (!dq.isEmpty()) {
//            int dqLen = dq.size();
//            for (int i = 0; i < dqLen; i++) {
//                level++;
//                TreeNode node = dq.pollFirst();
//                if(level == 1 && dqLen - 1 == 0){ // Root node
//                    res.add(node.val);
//                }else if (i == dqLen - 1) { // right most
//                    rightMost.add(node.val);
//                } else if (i == 0) { // left most
//                    res.add(node.val);
//                } else if (node.left == null && node.right == null) { // leaf node
//                    leaves.add(node.val);
//                }
//                if (node.left != null) dq.offer(node.left);
//                if (node.right != null) dq.offer(node.right);
//            }
//        }
//        Collections.reverse(rightMost);
//        res.addAll(leaves);
//        res.addAll(rightMost);
//        return res;
//    }

    static List<Integer> boundaryVals = new ArrayList<>();

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        boundaryVals.add(root.val);
        getLeftMostNodes(root.left);
        getLeaves(root.left);
        getLeaves(root.right);
        getRightMostNodes(root.right);

        return boundaryVals;
    }

    private static void getLeftMostNodes(TreeNode node) {
        if ((node == null) || (node.left == null && node.right == null)) return;

        boundaryVals.add(node.val);
        if (node.left == null) {
            getLeftMostNodes(node.right);
        } else {
            getLeftMostNodes(node.left);
        }
    }

    private static void getLeaves(TreeNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            boundaryVals.add(node.val);
            return;
        }

        getLeaves(node.left);
        getLeaves(node.right);
    }

    private static void getRightMostNodes(TreeNode node) {
        if ((node == null) || (node.left == null && node.right == null)) return;

        if (node.right == null) {
            getRightMostNodes(node.left);
        } else {
            getRightMostNodes(node.right);
        }
        boundaryVals.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(7);
        tree.right.right = new TreeNode(6);
        System.out.println(boundaryOfBinaryTree(tree)); //[1,2,3,4,5,6,7]
    }
}
