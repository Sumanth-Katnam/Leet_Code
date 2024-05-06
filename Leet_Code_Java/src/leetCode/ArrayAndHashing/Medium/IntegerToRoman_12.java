package leetCode.ArrayAndHashing.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        Map<Integer, String> numRomanMap = new TreeMap<>(Collections.reverseOrder());
        numRomanMap.put(1000, "M");
        numRomanMap.put(900, "CM");
        numRomanMap.put(500, "D");
        numRomanMap.put(400, "CD");
        numRomanMap.put(100, "C");
        numRomanMap.put(90, "XC");
        numRomanMap.put(50, "L");
        numRomanMap.put(40, "XL");
        numRomanMap.put(10, "X");
        numRomanMap.put(9, "IX");
        numRomanMap.put(5, "V");
        numRomanMap.put(4, "IV");
        numRomanMap.put(1, "I");

        StringBuilder res = new StringBuilder();
        for(int v:  numRomanMap.keySet()){
            res.append(numRomanMap.get(v).repeat(Math.floorDiv(num, v)));
            num = num % v;
        }
        return res.toString();
    }
}
