package leetCode.ArrayAndHashing.Easy;

import java.util.Arrays;

public class DesignHashMap_706 {
    class MyHashMap {
        private int[] storage;
        public MyHashMap() {
            storage = new int[((int) Math.pow(10, 6)) + 1];
            Arrays.fill(storage, -1);
        }

        public void put(int key, int value) {
            storage[key] = value;
        }

        public int get(int key) {
            return storage[key];
        }

        public void remove(int key) {
            storage[key] = -1;
        }
    }
}
