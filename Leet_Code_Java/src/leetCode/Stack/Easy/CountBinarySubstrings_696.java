package leetCode.Stack.Easy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        Stack<Pair<Character, Integer>> charCountList = new Stack<>();
        int res = 0, currCnt = 0;
        char currChar = s.charAt(0);

        for(char ch: s.toCharArray()){
            if(ch != currChar){
                charCountList.add(new Pair<>(currChar, currCnt));
                currChar = ch;
                currCnt = 0;
            }
            currCnt++;

            if(!charCountList.isEmpty() && charCountList.peek().getKey() != ch && charCountList.peek().getValue() >= currCnt)
                res++;
        }
        return res;

//        int prev=0, curr=1 , ans=0;
//
//        for(int i=1;i<s.length();i++){
//            if(s.charAt(i)!=s.charAt(i-1)){
//                ans+=Math.min(curr,prev);
//                prev=curr;
//                curr=1;
//            }else{
//                curr++;
//            }
//        }
//
//        return ans+Math.min(curr,prev);
    }
}
