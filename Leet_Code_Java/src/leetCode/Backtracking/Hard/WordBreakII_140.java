package leetCode.Backtracking.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII_140 {
    private void backtrack(int pos, ArrayList<String> words, List<String> res, Set<String> dict, String s) {
        if(pos == s.length()){
            res.add(String.join(" ", words));
        } else {
            for(int i = pos; i < s.length(); i++){
                if(dict.contains(s.substring(pos, i + 1))){
                    words.add(s.substring(pos, i + 1));
                    backtrack(i + 1, words, res, dict, s);
                    words.remove(words.size() - 1);
                }
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), res, dict, s);
        return res;
    }
}
