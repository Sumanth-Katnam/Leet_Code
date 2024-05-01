package leetCode.ArrayAndHashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class CountingElements_1426 {
    public static int countElements(int[] arr) {
        Map<Integer, Integer> cnt_map = new HashMap<>();
        for(int num: arr){
            if(!cnt_map.containsKey(num)){
                cnt_map.put(num, 1);
            } else {
                cnt_map.put(num, cnt_map.get(num) + 1);
            }
        }

        int res = 0;
        for(int num: cnt_map.keySet()){
            if(cnt_map.containsKey(num + 1))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,2,3}));
        System.out.println(countElements(new int[]{1,1,3,3,5,5,7,7}));
    }
}
