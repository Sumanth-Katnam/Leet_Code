package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class CreateBinaryTreeFromDescriptions_2196 {
    private static TreeNode buildTree(Map<Integer, int[]> nodes, int nodeVal){
        TreeNode node = new TreeNode(nodeVal);
        if(nodes.containsKey(nodeVal)){
            int[] children = nodes.get(nodeVal);

            if(children[0] != -1){
                node.left = buildTree(nodes, children[0]);
            }

            if(children[1] != -1){
                node.right = buildTree(nodes, children[1]);
            }
        }
        return node;
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> nodes = new HashMap<>();
        Set<Integer> hasParent = new HashSet<>();

        for(int[] desc: descriptions){
            if(!nodes.containsKey(desc[0])){
                int[] childNodes = new int[2];
                Arrays.fill(childNodes, -1);
                nodes.put(desc[0], childNodes);
            }

            if(desc[2] == 1){
                nodes.get(desc[0])[0] = desc[1];
            } else {
                nodes.get(desc[0])[1] = desc[1];
            }

            hasParent.add(desc[1]);
        }

        int rootVal = nodes.keySet().stream().filter((node) -> !hasParent.contains(node)).toList().get(0);

        return buildTree(nodes, rootVal);
    }

    public static void main(String[] args) {
        System.out.println(createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));
    }
}
