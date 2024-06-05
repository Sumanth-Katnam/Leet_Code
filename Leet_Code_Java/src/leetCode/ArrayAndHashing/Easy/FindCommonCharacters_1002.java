package leetCode.ArrayAndHashing.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters_1002 {
    private Map<Character, Integer> getCount(String str){
        Map<Character, Integer> countMap = new HashMap<>();

        for(Character ch: str.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        return countMap;
    }
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> charMap = getCount(words[0]);
        Map<Character, Integer> currMap, newMap;
        for(int i = 1; i < words.length; i++){
            currMap = getCount(words[i]);
            newMap = new HashMap<>();
            for(Character ch: currMap.keySet()){
                if(!charMap.containsKey(ch)){
                    continue;
                } else{
                    newMap.put(ch, Math.min(currMap.get(ch), charMap.get(ch)));
                }
            }
            charMap = newMap;
        }
        List<String> res = new ArrayList<>();
        for(Character ch: charMap.keySet()){
            for(int i = 0; i < charMap.get(ch); i++){
                res.add(String.valueOf(ch));
            }
        }
        return res;
    }
}
