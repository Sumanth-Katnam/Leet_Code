package leetCode.LinkedLists.Medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    class LRUCache {
        private final int cap;
        private int currCnt;
        private final Map<Integer, Node> cache;
        private final Node leftMost;
        private final Node rightMost;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.currCnt = 0;
            this.cache = new HashMap<>();
            this.leftMost = new Node(-1, -1);
            this.rightMost = new Node(-1, -1);
            this.leftMost.next = this.rightMost;
            this.rightMost.prev = this.leftMost;
        }

        private void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            this.currCnt--;
        }

        private void insert(Node node){
            Node prev = this.rightMost.prev;
            Node next = this.rightMost;
            prev.next = next.prev = node;
            node.prev = prev;
            node.next = next;
            this.currCnt++;
        }

        public int get(int key) {
            if(this.cache.containsKey(key)){
                remove(this.cache.get(key));
                insert(this.cache.get(key));
                return this.cache.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(this.cache.containsKey(key))
                remove(this.cache.get(key));

            cache.put(key, new Node(key, value));
            insert(this.cache.get(key));

            if(this.currCnt > this.cap){
                Node lru = this.leftMost.next;
                remove(lru);
                this.cache.remove(lru.key);
            }
        }
    }
}
