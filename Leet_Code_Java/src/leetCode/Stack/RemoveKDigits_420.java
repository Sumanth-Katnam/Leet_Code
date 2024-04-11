package leetCode.Stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits_420 {
    public static String removeKdigits_(String num, int k) {
        int len = num.length();
        if (k == len){
            return "0";
        }

        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        }


//         if there is still k remove last k
        while (k > 0) {
            stk.pop();
            k--;
        }


        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for(char n: num.toCharArray()){
            while(!stk.isEmpty() && k != 0 && (int) stk.peek() > (int) n){
                stk.pop();
                k -= 1;
            }
            // to avoid leading zeros
            if(!stk.isEmpty() || n != '0')
                stk.add(n);
        }


//         if there is still k remove last k
        if(k != 0){
            for (int i = 0; i < k; i++) {
                if(!stk.isEmpty())
                    stk.pop();
            }
        }


        return !stk.isEmpty() ? stk.stream().map(Object::toString).collect(Collectors.joining()) : "0";
    }

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }
}
