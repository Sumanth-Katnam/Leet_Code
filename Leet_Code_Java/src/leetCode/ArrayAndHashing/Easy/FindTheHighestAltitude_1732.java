package leetCode.ArrayAndHashing.Easy;

public class FindTheHighestAltitude_1732 {
    public int largestAltitude(int[] gain) {
        int res = 0, currGain = 0;

        for(int g : gain){
            currGain += g;
            if(currGain > res)
                res = currGain;
        }
        return res;
    }
}
