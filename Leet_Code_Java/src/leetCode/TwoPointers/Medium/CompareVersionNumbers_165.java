package leetCode.TwoPointers.Medium;

public class CompareVersionNumbers_165 {
    private int[] helper(String s, int idx){
        int num = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == '.'){
                break;
            }
            num = num * 10 + (int) s.charAt(idx);
            idx ++;
        }
        return new int[]{num, idx + 1};
    }
    public int compareVersion(String version1, String version2) {
        int i = 0, j=  0;
        int ver1Num, ver2Num;
        int[] versionInfo;
        while(i < version1.length() || j < version2.length()){
            versionInfo = helper(version1, i);
            ver1Num = versionInfo[0];
            i = versionInfo[1];

            versionInfo = helper(version2, j);
            ver2Num = versionInfo[0];
            j = versionInfo[1];

            if(ver1Num > ver2Num)
                return 1;
            else if (ver1Num < ver2Num)
                return -1;
        }
        return 0;
    }
}
