package leetCode.BinarySearch.Medium;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays_1011 {
    private static boolean canShip(int[] weights, int days, int shipSize){
        int currWeight = 0;
        int currDays = 0;
        for(int weight: weights){
            currWeight += weight;

            if(currWeight > shipSize){
                currDays++;
                currWeight = weight;
            }
        }
        return (currDays + 1) <= days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = 0, mid;
        for (int weight : weights) {
            low = Math.max(weight, low);
            high += weight;
        }
        int res = high;
        while(low <= high){
            mid = (low + high)/2;

            if(canShip(weights, days, mid)){
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3)); //6
    }
}
