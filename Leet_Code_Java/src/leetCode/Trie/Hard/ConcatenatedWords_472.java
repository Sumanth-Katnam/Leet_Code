package leetCode.Trie.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords_472 {
    class Trie {
        Map<Character, Trie> children;
        String word;
        Trie() {
            this.children = new HashMap<>();
            this.word = null;
        }
        void add(String s) {
            Trie node = this;
            for(char c : s.toCharArray()) {
                node = node.children.computeIfAbsent(c, k->new Trie());
            }
            node.word = s;
        }
    }

    boolean isWordConcatenated(Trie root, String word, int idx, int wordsSoFar, Boolean[] dp) {
        if(idx == word.length())
            return wordsSoFar > 1;

        if(dp[idx] == null) {
            Trie node = root;
            for(int i = idx; i < word.length(); i++) {
                if(!node.children.containsKey(word.charAt(i))) {
                    dp[idx] = false;
                    break;
                }
                node = node.children.get(word.charAt(i));
                if(node.word != null) {
                    boolean found = isWordConcatenated(root, word, i + 1, wordsSoFar+1, dp);
                    if(found) {
                        dp[idx] = true;
                        break;
                    }
                }
            }
            dp[idx] = dp[idx] == null ? false : dp[idx];
        }
        return dp[idx];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            root.add(word);
        }
        List<String> result = new ArrayList<>();

        for(String word : words) {
            Boolean[] dp = new Boolean[word.length()];
            boolean concatenated = isWordConcatenated(root, word, 0, 0, dp);
            if(concatenated) {
                result.add(word);
            }
        }

        return result;
    }
}
