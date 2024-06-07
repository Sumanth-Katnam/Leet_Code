package helpers;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public String end;

    public TrieNode(){
        this.children = new HashMap<>();
        this.end = "";
    }
}
