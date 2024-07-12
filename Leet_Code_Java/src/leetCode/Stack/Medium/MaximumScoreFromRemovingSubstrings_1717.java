package leetCode.Stack.Medium;

import java.util.Stack;
import java.util.stream.Collectors;

public class MaximumScoreFromRemovingSubstrings_1717 {
    public static int maximumGain(String s, int x, int y) {
        String first, second;
        int firstScore, secondScore;
        if(x > y){
            first = "ab";
            firstScore = x;
            second = "ba";
            secondScore = y;
        } else {
            first = "ba";
            firstScore = y;
            second = "ab";
            secondScore = x;
        }

        int res = 0;
        Stack<Character> stk1 = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!stk1.isEmpty() && first.equals("" + stk1.peek() + ch)){
                res += firstScore;
                stk1.pop();
            } else {
                stk1.add(ch);
            }
        }

        Stack<Character> stk2 = new Stack<>();
        String remainingString = stk1.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        for(char ch: remainingString.toCharArray()){
            if(!stk2.isEmpty() && second.equals("" + stk2.peek() + ch)){
                res += secondScore;
                stk2.pop();
            } else {
                stk2.add(ch);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5)); //19
    }
}
