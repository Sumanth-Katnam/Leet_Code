package leetCode.Stack;

public class MaximumNestingDepthOfTheParentheses_1614 {
    public int maxDepth(String s) {
        int res = 0, depth = 0;

        for(int idx = 0; idx < s.length(); idx++){
            if (s.charAt(idx) == '(')
                depth++;
            else if(s.charAt(idx) == ')')
                depth--;

            res = Math.max(res, depth);
        }
        return res;
    }
}
