package leetCode.HeapPriorityQueue.Hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays_4 {
    private static void addNum(PriorityQueue<Integer> leftElems, PriorityQueue<Integer> rightElems, int num){
        leftElems.add(num);

        if(!leftElems.isEmpty() && !rightElems.isEmpty() && leftElems.peek() > rightElems.peek()){
            rightElems.add(leftElems.poll());
        }
        if(leftElems.size() > rightElems.size() + 1){
            rightElems.add(leftElems.poll());
        }
        if(rightElems.size() > leftElems.size() + 1){
            leftElems.add(rightElems.poll());
        }
    }

    private static double findMedian(PriorityQueue<Integer> leftElems, PriorityQueue<Integer> rightElems){
        int leftLen = leftElems.size();
        int rightLen = rightElems.size();
        double res;
        if(leftLen > rightLen){
            res = leftElems.peek();
        } else if(rightLen > leftLen){
            res = rightElems.peek();
        } else {
            res = (leftElems.peek() + rightElems.peek()) /2.0;
        }
        return res;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> leftElems = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightElems = new PriorityQueue<>();

        for(int num: nums1) addNum(leftElems, rightElems, num);
        for(int num: nums2) addNum(leftElems, rightElems, num);

        return findMedian(leftElems, rightElems);
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
