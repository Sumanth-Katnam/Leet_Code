package leetCode.Greedy.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumNumberOfPushesToTypeWordII_3016 {
    public int minimumPushes(String word) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (char ch: word.toCharArray()){
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> sortedCounts = cntMap.values().stream().sorted(Collections.reverseOrder()).toList();

        int res = 0;
        int keysAssigned = 0;
        for(Integer cnt: sortedCounts){
            int cost = 1 + keysAssigned / 8;
            res += cost * cnt;
            keysAssigned++;
        }

        return res;
    }
}
