package leetCode.MathAndGeomerty.Easy;

import java.util.*;

public class HighFive_1086 {
    public static int[][] highFive(int[][] scores){
        Map<Integer, PriorityQueue<Integer>> score_map = new HashMap<>();
        for(int[] score: scores){
            score_map.computeIfAbsent(score[0], i -> new PriorityQueue<>((a, b) -> b - a)).add(score[1]);
        }

        int[][] res = new int[score_map.keySet().size()][2];
        PriorityQueue<Integer> allScores;
        int total;
        for(int id: score_map.keySet()){
            allScores = score_map.get(id);
            total = 0;
            for(int i = 0; i < 5; i++){
                total += allScores.poll();
            }

            res[id - 1][0] = id;
            res[id - 1][1] = total / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highFive(new int[][]{
                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}
        })));
    }
}
