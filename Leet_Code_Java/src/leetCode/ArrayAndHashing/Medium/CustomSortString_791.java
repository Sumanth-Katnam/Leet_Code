package leetCode.ArrayAndHashing.Medium;

import java.util.*;

public class CustomSortString_791 {
    private void addToRes(char ch, Map<Character, Integer> cntMap, StringBuilder res){
        char[] charArray = new char[cntMap.get(ch)];
        Arrays.fill(charArray, ch);
        res.append(new String(charArray));
    }
    public String customSortString(String order, String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            cntMap.merge(ch, 1, Integer::sum);
        }

        var res = new StringBuilder();
        // Adding the chars that occur in order
        for (Character ch : order.toCharArray()) {
            if (cntMap.containsKey(ch)) {
                addToRes(ch, cntMap, res);
                cntMap.remove(ch);
            }
        }

        //Adding remaining chars
        for (Character ch : cntMap.keySet()) {
            addToRes(ch, cntMap, res);
        }
        return res.toString();
    }
}
