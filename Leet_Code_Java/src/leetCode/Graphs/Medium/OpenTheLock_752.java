package leetCode.Graphs.Medium;

import javafx.util.Pair;

import java.util.*;

public class OpenTheLock_752 {
    public static int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String curr_num = current.getKey();
            int moves = current.getValue();

            if (curr_num.equals(target)) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int new_digit = (curr_num.charAt(i) - '0' + delta + 10) % 10;
                    String new_num = curr_num.substring(0, i) +
                            new_digit +
                            curr_num.substring(i + 1);

                    if (!visited.contains(new_num) && !deadSet.contains(new_num)) {
                        visited.add(new_num);
                        queue.offer(new Pair<>(new_num, moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202")); //6
    }
}
