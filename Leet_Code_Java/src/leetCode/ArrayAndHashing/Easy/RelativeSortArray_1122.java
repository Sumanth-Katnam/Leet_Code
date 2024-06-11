package leetCode.ArrayAndHashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num: arr1){
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int resPos = 0;
        for(int num: arr2){
            for(int i = 0; i < cntMap.get(num); i++){
                res[resPos] = num;
                resPos++;
            }
            cntMap.remove(num);
        }
        int[] remNums = cntMap.keySet().stream().sorted().mapToInt(i -> i).toArray();
        for(int num: remNums){
            for(int i = 0; i < cntMap.get(num); i++){
                res[resPos] = num;
                resPos++;
            }
        }
        return res;
    }
}
