package leetCode.SlidingWindow.Hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfTheLongestValidSubstring_2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int len = 0;
        Set<String> all = new HashSet<>();
        for (String s : forbidden) {
            all.add(s);
            len = Math.max(len, s.length());
        }
        int n = word.length();
        int r = 0;
        for (int i = n - 1, right = n; right > r && i >= 0; --i) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < right && j - i < len; ++j) {
                temp.append(word.charAt(j));
                if (all.contains(temp.toString())) {
                    right = j;
                    break;
                }
            }
            r = Math.max(r, right - i);
        }
        return r;
    }
}
