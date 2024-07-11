package leetCode.Greedy.Medium;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNumberOfKeypresses_2268 {
    public int minimumKeypresses(String s) {
        int[] charCnt = new int[26];
        for(char ch: s.toCharArray()){
            charCnt[ch - 'a']++;
        }

        Arrays.sort(charCnt);
        int res = 0;
        int key = 0;
        for(int i = charCnt.length - 1; i >= 0; i--){
            if(charCnt[i] == 0) continue;
            res += charCnt[i]* (key/9 + 1);
            key++;
        }
        return res;
    }
}
