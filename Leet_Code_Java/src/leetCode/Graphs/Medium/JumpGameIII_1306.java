package leetCode.Graphs.Medium;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(start);
        int n = arr.length, i = start;
        int leftIdx, rightIdx;
        while(!dq.isEmpty() && arr[i] != 0){
            i = dq.pollFirst();
            leftIdx = i - arr[i];
            rightIdx = i + arr[i];

            if(leftIdx > -1 && arr[leftIdx] > -1)
                dq.add(leftIdx);

            if (rightIdx < n && arr[rightIdx] > -1)
                dq.add(rightIdx);

            arr[i] *= -1;
        }
        return arr[i] == 0;
    }
}
