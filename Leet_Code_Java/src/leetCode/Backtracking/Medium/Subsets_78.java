package leetCode.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets_78 {
    private void backtrack(List<List<Integer>> res, int[] nums, Stack<Integer> subset, int pos) {
        if(pos == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[pos]);
        backtrack(res, nums, subset, pos + 1);
        subset.pop();
        backtrack(res, nums, subset, pos + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new Stack<>(), 0);
        return res;
    }
}
