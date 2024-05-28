package leetCode.SlidingWindow.Medium;

public class GetEqualSubstringsWithinBudget_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, currCost = 0, res = -1;
        for(int j = 0; j < s.length(); j++){
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            while (currCost > maxCost){
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
