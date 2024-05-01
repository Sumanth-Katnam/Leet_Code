package leetCode.ArrayAndHashing.Easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice_2351 {
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();

        for(char ch: s.toCharArray()){
            if(seen.contains(ch)){
                return ch;
            }
            seen.add(ch);
        }
        return ' ';
    }
}
