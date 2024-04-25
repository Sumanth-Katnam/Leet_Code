package leetCode.DP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIdealSubsequence_2370 {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int idx, left , right, prev_long, res = 0;
        for(char ch: s.toCharArray()){
            idx = ch - 'a';
            left = Math.max(idx - k, 0);
            right = Math.min(idx + k, 26);
            prev_long = Integer.MIN_VALUE;
            for (int prev = left; prev < right + 1; prev++) {
                prev_long = Math.max(prev_long, dp[prev]);
            }
            dp[idx] = prev_long + 1;
            if(res < dp[idx]) res = dp[idx];
        }
        return res;
    }
}
