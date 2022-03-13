package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber_136 {
    public static int singleNumber(int[] nums) {
//        int i = 0;
//        int prev;
//        List<Integer> checkedPositions = new ArrayList<>();
//        while(i < nums.length){
//            prev = i;
//            for (int j = i + 1; j < nums.length; j++){
//                if(checkedPositions.contains(i)){
//                    i+=1;
//                    break;
//                } else if(nums[i] == nums[j]){
//                    checkedPositions.add(i);
//                    checkedPositions.add(j);
//                    i++;
//                    break;
//                }
//            }
//            if(prev == i)
//                return nums[i];
//        }
//        return 0;
        int res = 0;
        for(int i: nums){
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
//        singleNumber(new int[]{4,1,2,1,2});
        singleNumber(new int[]{1,0,1});
    }
}
