package leetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> char_cnt = new HashMap<>();

        for(Character ch: s.toCharArray()){
            if(!char_cnt.containsKey(ch)){
                char_cnt.put(ch, 1);
            } else {
                char_cnt.put(ch, char_cnt.get(ch) + 1);
            }
        }

        for(Character ch: t.toCharArray()){
            if(!char_cnt.containsKey(ch)){
                return false;
            }
            char_cnt.put(ch, char_cnt.get(ch) - 1);

            if(char_cnt.get(ch) == 0){
                char_cnt.remove(ch);
            }
        }
        return char_cnt.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram( "anagram", "nagaram"));
        System.out.println(isAnagram( "rat", "car"));
    }
}
