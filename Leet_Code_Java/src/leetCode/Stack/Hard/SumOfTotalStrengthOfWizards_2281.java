package leetCode.Stack.Hard;

import javafx.util.Pair;

import java.util.Stack;

public class SumOfTotalStrengthOfWizards_2281 {
    public static int totalStrength1(int[] strength) {
        int res = 0, ac = 0, mod = (int)1e9 + 7, n = strength.length;
        Stack<Integer> stack = new Stack<>();
        int[] acc = new int[n + 2];
        for (int r = 0; r <= n; ++r) {
            int a = r < n ? strength[r] : 0;
            ac = (ac + a) % mod;
            acc[r + 1] = (ac + acc[r]) % mod;
            while (!stack.isEmpty() && strength[stack.peek()] > a) {
                int i = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                long lacc = l < 0 ? acc[i] : acc[i] - acc[l], racc = acc[r] - acc[i];
                int ln = i - l, rn = r - i;
                res = (int)(res + (racc * ln - lacc * rn) % mod * strength[i] % mod) % mod;
            }
            stack.push(r);
        }
        return (res + mod) % mod;
    }

    public static int totalStrength(int[] strength) {
        int[] preSum = new int[strength.length];
        preSum[0] = strength[0];
        for(int i = 1; i < strength.length; i++){
            preSum[i] = strength[i] + preSum[i - 1];
        }

        int res = 0;
        Stack<Pair<Integer, Integer>> monoNonDec = new Stack<>();
        for(int i = 0; i < strength.length; i++){
            res += strength[i] * strength[i];

            while(!monoNonDec.isEmpty() && monoNonDec.peek().getKey() >= strength[i]){
                monoNonDec.pop();
            }
            monoNonDec.add(new Pair<>(strength[i], i));

            for(int j = i - 1; j >= 0; j--){
                int k = monoNonDec.size() - 1;
                while(k > 0 && monoNonDec.get(k).getValue() > j) k--;
                k = Math.max(k + 1, 0);
                int subSum = preSum[i] - (j - 1 >= 0? preSum[j - 1]: 0);
                res += monoNonDec.get(k).getKey() * (subSum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalStrength(new int[]{8,1,8,5}));
    }
}
