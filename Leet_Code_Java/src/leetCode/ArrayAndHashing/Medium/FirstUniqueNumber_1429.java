package leetCode.ArrayAndHashing.Medium;

import java.util.*;

public class FirstUniqueNumber_1429 {

    static class FirstUnique {
        List<Integer> queue = new ArrayList<>();
        Map<Integer, Integer> numCntMap = new LinkedHashMap<>();
        public FirstUnique(int[] nums) {
            for(int num: nums){
                add(num);
            }
        }

        public int showFirstUnique() {
            for(int key: this.numCntMap.keySet()){
                if(numCntMap.get(key) == 1) return key;
            }
            return -1;
        }

        public void add(int value) {
            this.queue.add(value);
            this.numCntMap.merge(value, 1, Integer::sum);
        }
    }
}
