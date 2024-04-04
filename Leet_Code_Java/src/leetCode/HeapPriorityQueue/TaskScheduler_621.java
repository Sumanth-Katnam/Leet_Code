package leetCode.HeapPriorityQueue;

import java.util.Arrays;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for( char letter : tasks){
            count[letter - 'A'] ++;
        }

        int maxVal = Arrays.stream(count).max().getAsInt();
        int maxCount =  0;
        for(int l : count){
            if (l == maxVal)
                maxCount += 1;
        }

        return Math.max((maxVal - 1) * (n + 1) + maxCount, tasks.length);
    }
}
