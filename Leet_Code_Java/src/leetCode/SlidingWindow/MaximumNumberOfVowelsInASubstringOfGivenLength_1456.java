package leetCode.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength_1456 {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int currCnt = 0;
        for(int idx = 0; idx < k; idx++){
            if(vowels.contains(s.charAt(idx)))
                currCnt += 1;
        }

        int i = 0, j = k;
        int res = currCnt;

        while(j < s.length()){
            if(vowels.contains(s.charAt(i)))
                currCnt -= 1;

            if(vowels.contains(s.charAt(j)))
                currCnt += 1;

            if(currCnt > res)
                res = currCnt;

            i++;
            j++;
        }

        return res;
    }
}
