package leetCode.DP1.Medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_91 {
    private int decodeCounter(Map<Integer, Integer> decodeMap, String s, int idx){
        if(decodeMap.containsKey(idx)){
            return decodeMap.get(idx);
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }

        int res = decodeCounter(decodeMap, s, idx + 1);

        if(idx + 1 < s.length()){
            int subVal = Integer.parseInt(s.substring(idx, idx+2));
            if(10 <= subVal && subVal <= 26){
                res += decodeCounter(decodeMap, s,  idx + 2);
            }
        }
        decodeMap.put(idx, res);
        return res;
    }
    public int numDecodings(String s) {
        Map<Integer, Integer> decodeMap = new HashMap<>();
        decodeMap.put(s.length(), 1);
        return decodeCounter(decodeMap, s, 0);
    }
}
