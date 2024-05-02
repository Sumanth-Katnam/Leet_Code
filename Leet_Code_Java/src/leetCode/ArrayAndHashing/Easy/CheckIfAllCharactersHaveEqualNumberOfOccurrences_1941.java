package leetCode.ArrayAndHashing.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences_1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> cnt_map = new HashMap<>();
        for(char ch: s.toCharArray()){
            cnt_map.put(ch, cnt_map.computeIfAbsent(ch, k-> 0) + 1);
        }
        return new HashSet<>(cnt_map.values()).size() == 1;
    }
}
