package leetCode.Stack.Medium;

import java.util.Arrays;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
    private static void reverseStrings(char[] res, int start, int end){
        char temp;
        while(start < end){
            temp = res[start];
            res[start] = res[end];
            res[end] = temp;
            start++;
            end--;
        }
    }
    public static String reverseParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        char[] res = s.toCharArray();
        int start, end;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')') {
                start = stk.pop() + 1;
                end = i - 1;
                reverseStrings(res, start, end);
            } else if (s.charAt(i) == '('){
                stk.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: res){
            if(ch != '(' && ch != ')'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
    }
}
