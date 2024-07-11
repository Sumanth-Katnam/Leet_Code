package leetCode.ArrayAndHashing.Medium;

import java.util.Arrays;

public class PlatesBetweenCandles_2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] preSum = new int[s.length() + 1];
        int[] next = new int[s.length() + 1];
        int[] prev = new int[s.length() + 1];
        Arrays.fill(next, Integer.MAX_VALUE);

        for(int i = 0; i < s.length(); i++){
            preSum[i + 1] = preSum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }

        for (int i = s.length() - 1; i >= 0; i--){
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        }

        int res[] = new int[queries.length];
        int q_cnt = 0;
        for(int[] q: queries){
            int l = next[q[0]], r = prev[q[1] + 1];
            res[q_cnt] = l < r ? r - l - (preSum[r] - preSum[l]): 0;
            q_cnt++;
        }
        return res;
    }
}
