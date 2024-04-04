package leetCode.ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s_t = new HashMap<>();
        Map<Character, Character> t_s = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if((s_t.containsKey(s.charAt(i)) && s_t.get(s.charAt(i)) != t.charAt(i))
            || (t_s.containsKey(t.charAt(i)) && t_s.get(t.charAt(i)) != s.charAt(i)))
                return false;
            s_t.put(s.charAt(i), t.charAt(i));
            t_s.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}
