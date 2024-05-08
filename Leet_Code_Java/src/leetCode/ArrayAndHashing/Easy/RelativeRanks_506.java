package leetCode.ArrayAndHashing.Easy;

import java.util.*;

public class RelativeRanks_506 {
    public static String[] findRelativeRanks(int[] score) {
        Integer[] sortedScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedScore, Comparator.reverseOrder());

        Map<Integer, Integer> scoreMap = new HashMap<>();

        for(int idx = 0; idx < sortedScore.length; idx++){
            scoreMap.put(sortedScore[idx], idx + 1);
        }
        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] res = new String[score.length];

        for(int idx = 0; idx < score.length; idx++){
            if(scoreMap.get(score[idx]) <= 3)
                res[idx] = medals[scoreMap.get(score[idx]) - 1];
            else
                res[idx] = String.valueOf(scoreMap.get(score[idx]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
