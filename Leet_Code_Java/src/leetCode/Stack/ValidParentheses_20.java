package leetCode.Stack;

import java.util.*;

public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        Map<Character, Integer> dictionary = new HashMap<>(){{
            put('[', 1);
            put('(', 2);
            put('{', 3);
            put(']', -1);
            put(')', -2);
            put('}', -3);
        }};
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            Integer currentVal = dictionary.get(c);
            if(currentVal > 0){
                stack.push(c);
            } else if(!stack.isEmpty() && currentVal < 0){
                Integer topVal = dictionary.get(stack.pop());
                if(currentVal + topVal != 0){
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("){"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([{{[[()]]}}])"));
    }
}
