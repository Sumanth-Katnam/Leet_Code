package leetCode;

import java.util.*;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> pos_map = new HashMap<>();

        for(Character ch: s.toCharArray()){
            pos_map.put(ch, pos_map.getOrDefault(ch, 0) + 1);
        }


        StringBuilder res = new StringBuilder();

        for(Character ch: order.toCharArray()){
            if(pos_map.containsKey(ch)){
                char[] charArray = new char[pos_map.get(ch)];
                Arrays.fill(charArray, ch);
                res.append(new String(charArray));
                pos_map.remove(ch);
            }
        }


        for(Character ch : pos_map.keySet()){
            char[] charArray = new char[pos_map.get(ch)];
            Arrays.fill(charArray, ch);
            res.append(new String(charArray));
        }

        return res.toString();
    }
}
