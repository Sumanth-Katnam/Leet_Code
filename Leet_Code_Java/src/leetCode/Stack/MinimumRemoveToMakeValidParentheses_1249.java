package leetCode.Stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        int left_cnt = 0, right_cnt = 0;
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(')
                left_cnt += 1;
            else if(ch == ')')
                right_cnt += 1;

            if(right_cnt > left_cnt)
                right_cnt -= 1;
            else
                stk.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.empty()){
            char curr_char = stk.pop();
            if(left_cnt > right_cnt && curr_char == '(')
                left_cnt -= 1;
            else
                sb.append(curr_char);
        }

        return sb.reverse().toString();
    }
}
