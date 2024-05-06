package leetCode.HeapPriorityQueue.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            maxHeap.add(num);
        }

        while(k > 1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
    }
}
