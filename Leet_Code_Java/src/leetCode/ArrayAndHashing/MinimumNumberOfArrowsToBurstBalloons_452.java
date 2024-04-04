package leetCode.ArrayAndHashing;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
//
//        int n = points.length;
//        int i = 0;
//        int shots = 0;
//        int j;
//
//        while(i < n){
//            // find everything that overlaps with first point
//            j = i + 1;
//            while(j < n){
//                if (points[j][0] > points[i][1])
//                    break;
//                j += 1;
//            }
//
//            shots += 1;
//            i = j;
//        }
//
//        return shots;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                ++arrows;
                end = points[i][1];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons_452 sol = new MinimumNumberOfArrowsToBurstBalloons_452();
        System.out.println(sol.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
