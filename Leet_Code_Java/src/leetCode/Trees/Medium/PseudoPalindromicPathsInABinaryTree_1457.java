package leetCode.Trees.Medium;

import helpers.TreeNodeMain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree_1457 {
    private int dfs(TreeNode root, Map<Integer, Integer> numCnt) {
        if (root == null) return 0;

        numCnt.merge(root.val, 1, Integer::sum);
        // If leaf
        if (root.left == null && root.right == null) {
            long cnt = numCnt.values().stream().filter(v -> v % 2 == 1).count();
            numCnt.put(root.val, numCnt.get(root.val) - 1);
            return cnt <= 1 ? 1 : 0;
        }

        int leftCnt = dfs(root.left, numCnt);
        int rightCnt = dfs(root.right, numCnt);
        numCnt.put(root.val, numCnt.get(root.val) - 1);
        return leftCnt + rightCnt;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new HashMap<>());
    }
}
