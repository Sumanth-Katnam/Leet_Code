package leetCode.SlidingWindow.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0, end = 0;
        int numsLen = nums.length;
        int[] res = new int[numsLen - (k - 1)];
        int resIdx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        while(end != numsLen){
            while(!dq.isEmpty() && nums[dq.peek()] < nums[end]){
                dq.poll();
            }
            dq.add(end);

            if(start > dq.peekFirst()){
                dq.pollFirst();
            }

            if(end + 1 >= k){
                res[resIdx] = nums[dq.peekFirst()];
                resIdx++;
                start++;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); //[3,3,5,5,6,7]
    }
}
