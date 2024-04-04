package leetCode.Trees;

import helpers.TreeNodeMain;
import helpers.TreeNodeMain.TreeNode;

import java.util.List;

public class CountCompleteTreeNodes_222 {
    public static int countNodes(TreeNode root) {
        int height = 0;
        TreeNode leftCheckNode = root;
        while (leftCheckNode != null){
            leftCheckNode = leftCheckNode.left;
            height ++;
        }


        int nullNodes = countNullNodesAtLevel(root, 0, height, 0);

        return nullNodes;
    }

    private static int countNullNodesAtLevel(TreeNode root, int level, int target, int nullCount){
        if(root == null && level == target){
            nullCount ++;
            return nullCount;
        }
        if(level == 0){
            System.out.print(root.val + " ");
        }else{
            countNullNodesAtLevel(root.left, level-1, target, nullCount);
            countNullNodesAtLevel(root.right, level-1, target, nullCount);
        }
        return nullCount;
    }

    public static void main(String[] args) {
        TreeNode p = TreeNodeMain.populateTree(List.of(new Integer[]{1, 2, 3, 4, 5, 6}));
        System.out.println(countNodes(p));
    }
}
