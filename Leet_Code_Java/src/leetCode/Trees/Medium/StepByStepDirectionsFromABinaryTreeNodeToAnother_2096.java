package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother_2096 {
    private TreeNode getAncestor(TreeNode node, int start, int dest){
        if(node == null) return null;

        if(node.val == start || node.val == dest){
            return node;
        }

        TreeNode left = getAncestor(node.left, start, dest);
        TreeNode right = getAncestor(node.right, start, dest);

        if(left != null && right != null) return node;
        if(left != null) return left;
        return right;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode newRoot = getAncestor(root, startValue, destValue);
        String startPath = null, destPath = null;

        Deque<Pair<TreeNode, String>> dq = new ArrayDeque<>();
        dq.add(new Pair<>(newRoot, ""));

        while(!dq.isEmpty()){
            Pair<TreeNode, String> poppedPair = dq.pollFirst();
            TreeNode node = poppedPair.getKey();
            String path = poppedPair.getValue();

            if(node.val == startValue){
                startPath = path;
                if(destPath != null){
                    break;
                }
            }

            if(node.val == destValue){
                destPath = path;
                if(startPath != null){
                    break;
                }
            }

            if(node.left != null)
                dq.add(new Pair<>(node.left, path + "L"));

            if(node.right != null)
                dq.add(new Pair<>(node.right, path + "R"));
        }
        return "U".repeat(startPath.length()) + destPath;
    }
}
