package leetCode.ArrayAndHashing.Easy;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;

        int i = 0;
        for(int j= 0; j < t.length(); j++){
            if(s.charAt(i) == t.charAt(j)) {
                i += 1;
                if (i == s.length())
                    return true;
            }
        }
        return false;
    }
}
