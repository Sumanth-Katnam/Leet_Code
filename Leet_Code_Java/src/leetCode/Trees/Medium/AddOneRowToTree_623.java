package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddOneRowToTree_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode tree = new TreeNode(val);
            tree.left = root;
            return tree;
        }

        int level = 1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        TreeNode node;
        while(level != depth){
            int dq_len = dq.size();

            if(level + 1 == depth){
                TreeNode insert_left, insert_right;
                for(int i = 0; i < dq_len; i++){
                    node = dq.pollFirst();
                    insert_left = new TreeNode(val);
                    insert_right = new TreeNode(val);
                    insert_left.left = node.left;
                    insert_right.right = node.right;
                    node.left = insert_left;
                    node.right = insert_right;
                }
            } else {
                for(int i = 0; i < dq_len; i++){
                    node = dq.pollFirst();
                    if(node.left != null)
                        dq.add(node.left);

                    if(node.right != null)
                        dq.add(node.right);
                }
            }
            level++;
        }
        return root;
    }
}
