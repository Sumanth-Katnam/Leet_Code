package leetCode.ArrayAndHashing.Medium;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreaterElementIII_556 {
    public static int nextGreaterElement(int n) {
        char[] str_n = String.valueOf(n).toCharArray();
        int n_len = str_n.length;

        if(n_len == 1)
            return -1;

        // find a point where current num is less than next num
        int break_pos = n_len - 2;
        while(break_pos >= 0 && str_n[break_pos] >= str_n[break_pos + 1])
            break_pos -= 1;

        if(break_pos < 0)
            return -1;

        // find a point where current num is greater than break pos
        int replace_pos = n_len - 1;
        while(str_n[replace_pos] <= str_n[break_pos])
            replace_pos -= 1;

        // replace the next greater num with break num
        char temp = str_n[break_pos];
        str_n[break_pos] = str_n[replace_pos];
        str_n[replace_pos] = temp;

        // reverse the rest of the string starting from next position of break point
        int l = break_pos + 1, r = n_len - 1;
        while(l < r){
            temp = str_n[l];
            str_n[l] = str_n[r];
            str_n[r] = temp;
            l++;
            r--;
        }

        long ans_ = Long.parseLong(new String(str_n));
        return (ans_ > Integer.MAX_VALUE) ? -1 : (int)ans_;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(23102431));
    }
}
