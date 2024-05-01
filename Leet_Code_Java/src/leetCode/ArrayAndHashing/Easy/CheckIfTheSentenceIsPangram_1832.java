package leetCode.ArrayAndHashing.Easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram_1832 {
    public boolean checkIfPangram(String sentence) {
        Set<Character> char_set = new HashSet<>();
        for(char ch: sentence.toCharArray()){
            char_set.add(ch);
        }
        return char_set.size() == 26;
    }
}
