package leetCode.Backtracking.Medium;

import java.util.HashMap;
import java.util.Map;

public class TheNumberOfBeautifulSubsets_2597 {
    private int res;
    private final Map<Integer, Integer> visited;

    public TheNumberOfBeautifulSubsets_2597() {
        this.res = 0;
        this.visited = new HashMap<>();
    }

    public int beautifulSubsets(int[] nums, int k) {
        backtrack(nums, k, 0);
        return res - 1; // Subtract 1 to exclude the empty subset
    }

    private void backtrack(int[] nums, int k, int pos) {
        if (pos == nums.length) {
            res++;
            return;
        }

        int num = nums[pos];

        if (!visited.containsKey(num - k) && !visited.containsKey(num + k)) {
            visited.put(num, visited.getOrDefault(num, 0) + 1);
            backtrack(nums, k, pos + 1);
            visited.put(num, visited.get(num) - 1);
            if (visited.get(num) == 0) {
                visited.remove(num);
            }
        }

        backtrack(nums, k, pos + 1);
    }
}
