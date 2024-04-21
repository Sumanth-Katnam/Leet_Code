package leetCode.Graphs;

import java.util.*;

public class FindIfPathExistsInPath_1971 {
    private boolean dfs(int node, int destination, Set<Integer> visited, Map<Integer, List<Integer>> adj_list){
        if(node == destination)
            return true;

        visited.add(node);
        for(int i = 0; i < adj_list.get(node).size(); i++){
            int neighbor = adj_list.get(node).get(i);
            if(!visited.contains(neighbor))
                if(dfs(neighbor, destination, visited, adj_list))
                    return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj_list = new HashMap<>();

        for (int[] edge : edges) {
            if (!adj_list.containsKey(edge[0])) {
                adj_list.put(edge[0], new ArrayList<>());
            }
            if (!adj_list.containsKey(edge[1])) {
                adj_list.put(edge[1], new ArrayList<>());
            }
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(source, destination, visited, adj_list);
    }
}
