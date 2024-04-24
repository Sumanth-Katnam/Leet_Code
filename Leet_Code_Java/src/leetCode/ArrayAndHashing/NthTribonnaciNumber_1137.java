package leetCode.ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthTribonnaciNumber_1137 {
    public int tribonacci(int n) {
        List<Integer> trib_list = new ArrayList<>(Arrays.asList(0, 1, 1));
        int trib_size = 3;
        if(trib_size <= n){
            while(trib_size <= n){
                trib_list.add(trib_list.get(trib_size - 1) + trib_list.get(trib_size - 2) + trib_list.get(trib_size - 3));
                trib_size++;
            }
        }

        return trib_list.get(n);
    }
}
