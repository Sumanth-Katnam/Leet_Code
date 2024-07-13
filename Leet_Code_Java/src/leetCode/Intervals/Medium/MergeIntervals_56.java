package leetCode.Intervals.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            int prevEnd = res.get(res.size() - 1)[1];

            if(currStart <= prevEnd){
                res.get(res.size() - 1)[1] = Math.max(prevEnd, currEnd);
            } else {
                res.add(new int[]{currStart, currEnd});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
