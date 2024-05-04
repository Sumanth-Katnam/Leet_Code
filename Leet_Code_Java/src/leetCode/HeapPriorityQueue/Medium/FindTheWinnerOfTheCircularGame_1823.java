package leetCode.HeapPriorityQueue.Medium;

import java.util.Deque;
import java.util.LinkedList;

public class FindTheWinnerOfTheCircularGame_1823 {
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        int cnt;
        while (queue.size() > 1) {
            cnt = k -1;

            while (cnt != 0) {
                queue.add(queue.pollFirst());
                cnt--;
            }

            queue.pollFirst();
        }
        return queue.pop();
    }
}
