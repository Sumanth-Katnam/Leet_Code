package leetCode.Stack.Easy;

import java.util.Stack;

public class MakeTheStringGreat_1544 {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();

        for(Character ch : s.toCharArray()){
            if(!stk.isEmpty() && Math.abs(ch - stk.peek()) == 32){
                stk.pop();
                continue;
            }
            stk.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stk) {
            sb.append(ch);
        }
        return sb.toString();

//        return stk.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
