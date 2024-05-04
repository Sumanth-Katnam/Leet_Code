package leetCode.Greedy.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConstructSmallestNumberFromDIString_2375 {
    public String smallestNumber(String pattern) {
        List<Character> res = new ArrayList<>();
        int patLen = pattern.length();
        int descCount = 0;
        for(int i = 0; i < patLen; i++){
            if(pattern.charAt(i) == 'I'){
                for(int num = i; num > i - descCount - 1; num--){
                    res.add((char) (num + 1 + '0'));
                }
                descCount = 0;
            } else {
                descCount++;
            }
        }

        for(int num = patLen; num > patLen - descCount - 1; num--){
            res.add((char) (num + 1 + '0'));
        }
        return res.stream().map(Objects::toString).collect(Collectors.joining());
    }
}
