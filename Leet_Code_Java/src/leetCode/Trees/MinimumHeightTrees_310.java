package leetCode.Trees;

import java.util.*;

public class MinimumHeightTrees_310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return List.of(1);
        }
        Map<Integer, List<Integer>> adj_list = new HashMap<>();

        for(int[] edge: edges){
            adj_list.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj_list.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        Map<Integer, Integer> edge_cnt = new HashMap<>();

        for(int node : adj_list.keySet()){
            int nei_len = adj_list.get(node).size();
            edge_cnt.put(node, nei_len);
            if(nei_len == 1)
                leaves.add(node);
        }

        while(!leaves.isEmpty()){
            if(n <= 2)
                return new ArrayList<>(leaves);

            int leave_len = leaves.size();
            for(int i = 0; i < leave_len; i++){
                Integer node = leaves.poll();
                n--;

                for(int nei : adj_list.get(node)){
                    edge_cnt.put(nei, edge_cnt.get(nei) - 1);
                    if(edge_cnt.get(nei) == 1)
                        leaves.add(nei);
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{
                {1, 0}, {1, 2}, {1, 3}
        }));
    }
}
