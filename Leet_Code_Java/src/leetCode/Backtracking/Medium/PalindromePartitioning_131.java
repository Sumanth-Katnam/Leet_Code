package leetCode.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning_131 {
    private boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private void backtrack(List<List<String>>res, Stack<String> sub, String str, int pos){
        if(pos == str.length()){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = pos; i < str.length(); i++){
            if(isPalindrome(str.substring(pos, i + 1))){
                sub.add(str.substring(pos, i + 1));
                backtrack(res, sub, str, i + 1);
                sub.pop();
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new Stack<>(), s, 0);
        return res;
    }
}
