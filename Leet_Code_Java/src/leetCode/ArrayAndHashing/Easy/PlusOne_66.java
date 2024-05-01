package leetCode.ArrayAndHashing.Easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int pos = digits.length - 1;
        digits[pos] = digits[pos] + 1;
        int currNum = digits[pos];

        // recursively add 1 to the previous bits
        while(currNum > 9 && pos >= 1){
           digits[pos] = digits[pos] % 10;
           pos = pos - 1;
           digits[pos] = digits[pos] + 1;
           currNum = digits[pos];
        }
        if(currNum > 9){
            digits[pos] = digits[pos] % 10;
            digits = IntStream.concat(Arrays.stream(new int[]{currNum/10}), Arrays.stream(digits)).toArray();
        }
        return digits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
