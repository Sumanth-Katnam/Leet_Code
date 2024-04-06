package leetCode.SlidingWindow;

import java.math.BigInteger;
import java.util.Arrays;

public class KRadiusSubarrayAverages_2090 {
    public int[] getAverages(int[] nums, int k) {
//        int n = nums.length;
//        int[] res = new int[n];
//        Arrays.fill(res, -1);
//        int k2_1 = (2 * k) + 1;
//
//        if(k2_1 > n)
//            return res;
//
////        long window_sum = Arrays.stream(nums, 0, k2_1).sum();
//
//        BigInteger window_sum = new BigInteger(String.valueOf(0));
//        for(int i = 0; i < k2_1; i++){
//            window_sum = window_sum.add(BigInteger.valueOf(nums[i]));
//        }
//
//        res[k] = window_sum.divide(BigInteger.valueOf(k2_1)).intValueExact();
//        for(int i = k + 1; i < n - k; i++){
//            window_sum = window_sum.add(BigInteger.valueOf(nums[k + i] - nums[i - k - 1]));
//            res[i] = window_sum.divide(BigInteger.valueOf(k2_1)).intValueExact();
//        }
//
//        return res;

        if (k == 0) {
            return nums;
        }

        int windowSize = 2 * k + 1;
        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        if (windowSize > n) {
            return averages;
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int average = (int) (subArraySum / windowSize);
            averages[i] = average;
        }

        return averages;
    }
}
