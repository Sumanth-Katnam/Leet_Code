package leetCode.TwoPointers.Medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubstring_5 {
    private String getLongest(String str, int i, int j){
        while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }

    public String longestPalindrome(String s) {
        String res = "", pal;
        for(int i = 0; i < s.length(); i++){
            pal = getLongest(s, i, i);
            if(pal.length() > res.length())
                res = pal;
        }

        for(int i = 0; i < s.length() - 1; i++){
            pal = getLongest(s, i, i + 1);
            if(pal.length() > res.length())
                res = pal;
        }
        return res;
    }
}
