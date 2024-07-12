package leetCode.BinarySearch.Medium;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    private static Boolean canEat(int[] piles, int h, int k){
        long hours = 0;
        for (int pile : piles) {
            hours += (long) (Math.ceil((double) pile / (double) k));
        }
        return hours <= h;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int l = 0, r= Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(mid == 0) return res;
            if(canEat(piles, h, mid)){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 18));
    }
}
