package leetCode.Graphs.Hard;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail_514 {
    public int findRotateSteps(String ring, String key) {
        Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
        Map<Character, List<Integer>> positions = new HashMap<>();

        for(int i = 0; i < ring.length(); i++){
            positions.computeIfAbsent(ring.charAt(i), ch -> new ArrayList<>()).add(i);
        }

        return helper(0, 0, positions, key, ring, memo);
    }
    private int helper(int in, int pos, Map<Character, List<Integer>> positions, String key, String ring, Map<Pair<Integer, Integer>, Integer> memo) {
        if(in == key.length())
            return 0;

        Pair<Integer, Integer> pair = new Pair<>(in, pos);

        if(memo.containsKey(pair))
            return memo.get(pair);

        int min_steps = Integer.MAX_VALUE;
        int steps;
        for(int i: positions.get(key.charAt(in))) {
            if(i >= pos)
                steps = Math.min(i - pos, pos + ring.length() - i);
            else
                steps = Math.min(pos - i, i + ring.length() - pos);

            min_steps=Math.min(min_steps, steps + helper(in + 1, i, positions, key, ring, memo));
        }
        memo.put(pair, min_steps + 1);
        return min_steps + 1;
    }
}
