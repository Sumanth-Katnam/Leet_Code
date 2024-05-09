package leetCode.Greedy.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximizeHappinessOfSelectedChildren_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length, j = 0;
        int selectedVal;
        for (int i = n - 1; i >= n - k; --i) {
            selectedVal = happiness[i] - j++;
            if(selectedVal > 0)
                res += selectedVal;
        }

        return res;
    }
}
