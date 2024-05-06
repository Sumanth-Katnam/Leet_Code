package leetCode.Stack.Medium;

import java.util.Objects;
import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String repStr;
        int repCnt;
        for(char ch : s.toCharArray()){
            if (ch != ']')
                charStack.add(String.valueOf(ch));
            else{
                sb.setLength(0);
                while(!charStack.peek().equals("[")){
                    sb.append(charStack.pop());
                }
                charStack.pop();
                repStr = sb.toString();

                sb.setLength(0);
                while(!charStack.isEmpty() && Character.isDigit(charStack.peek().charAt(0))){
                    sb.append(charStack.pop());
                }
                sb.reverse();
                repCnt = Integer.parseInt(sb.toString());

                charStack.add(repStr.repeat(repCnt));
            }

        }
        sb.setLength(0);
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
