package leetCode.TwoPointers.Medium;

public class PalindromicSubstrings_647 {
    private int palindromeCounter(String s, int start, int end){
        int res = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            res++;
            start--;
            end++;
        }
        return res;
    }

    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            // Odd length count
            res += palindromeCounter(s, i, i);

            // Even length count
            res += palindromeCounter(s, i, i + 1);
        }
        return res;
    }
}
