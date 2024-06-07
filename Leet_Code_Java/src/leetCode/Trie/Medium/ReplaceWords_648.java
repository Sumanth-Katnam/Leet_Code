package leetCode.Trie.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ReplaceWords_648 {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public String end;

        public TrieNode(){
            this.children = new HashMap<>();
            this.end = "";
        }
    }

    private void addWord(TrieNode root, String word){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if (!curr.children.containsKey(ch))
                curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.end = word;
    }

    private String getRoot(TrieNode root, String word){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch))
                return word;
            curr = curr.children.get(ch);
            if (!curr.end.isEmpty())
                return curr.end;
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary)
            addWord(root, word);

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = getRoot(root, words[i]);
        }

        return String.join(" ", words);
    }
}
