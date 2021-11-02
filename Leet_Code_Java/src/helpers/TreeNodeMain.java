package helpers;

import java.util.List;

public class TreeNodeMain {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    public static TreeNode testPopulate(List<Integer> nodes){
//        if(nodes.size() == 0) return null;
//        return testPopulate(nodes, 1);
//    }

//    public static TreeNode testPopulate(List<Integer> nodes, int leftChildIndex){
//        TreeNode node = new TreeNode(nodes.get(0));
//        node.left = testPopulate(nodes, leftChildIndex)
//    }

    public static TreeNode populateTree(List<Integer> nodes){
        return populateTree(nodes, 0, nodes.size() - 1);
    }

    private static TreeNode populateTree(List<Integer> nodes, int start, int end){
        if(end < start)
            return null;
        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = populateTree(nodes, start, mid - 1);
        node.right = populateTree(nodes, mid + 1, end);
        return node;
    }
}
