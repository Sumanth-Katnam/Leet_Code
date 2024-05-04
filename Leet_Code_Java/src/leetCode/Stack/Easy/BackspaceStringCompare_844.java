package leetCode.Stack.Easy;

import java.util.Stack;

public class BackspaceStringCompare_844 {
    private String helper(String a){
        Stack<Character> stk = new Stack<>();

        for(char ch: a.toCharArray()){
            if(ch == '#'){
                if(!stk.isEmpty())
                    stk.pop();
            } else {
                stk.add(ch);
            }
        }
        return String.valueOf(stk);
    }
    public boolean backspaceCompare(String s, String t) {
        return helper(s).compareTo(helper(t)) == 0;
    }
}
