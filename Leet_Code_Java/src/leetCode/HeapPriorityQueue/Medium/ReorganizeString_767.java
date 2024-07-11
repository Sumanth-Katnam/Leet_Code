package leetCode.HeapPriorityQueue.Medium;

import java.util.PriorityQueue;

public class ReorganizeString_767 {
    class CntPair {
        char ch;
        int cnt;

        public CntPair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String reorganizeString(String s) {
        int n = s.length();
        if (n == 0) return "";

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        // Lambda expression for custom comparison
        PriorityQueue<CntPair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.cnt, p1.cnt));

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new CntPair((char) (i + 97), arr[i]));
            }

        }
        CntPair prev = null;
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            //removing maximum element so that in next iteration we are not putting the same element
            CntPair curr = pq.poll();
            sb.append(curr.ch);
            curr.cnt--;
            if (prev != null && prev.cnt > 0) {
                //in next iterartion we are putting the removed element so that it can be processed for further calculations
                pq.add(prev);
            }
            prev = curr;
        }
        if (sb.length() != n) {
            return "";
        }

        return sb.toString();
    }
}
