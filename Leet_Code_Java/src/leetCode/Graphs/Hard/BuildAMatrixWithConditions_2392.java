package leetCode.Graphs.Hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BuildAMatrixWithConditions_2392_1 {
    private final Map<Integer, Set<Integer>> rowConditionsMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> colConditionsMap = new HashMap<>();

    // Returns true if there is loop
    private boolean dfs(int node, Set<Integer> currPath, Set<Integer> visited, Map<Integer, Set<Integer>> conditions) {
        if (visited.contains(node)) return false;
        if (currPath.contains(node)) return true;
        currPath.add(node);
        if (conditions.containsKey(node)) {
            for (int neighbor : conditions.get(node)) {
                if (dfs(neighbor, currPath, visited, conditions)) return true;
            }
        }
        visited.add(node);
        return false;
    }

    // perform DFS to find loop in the graph
    private boolean isConditionsMapInvalid(Map<Integer, Set<Integer>> conditions) {
        Set<Integer> visited = new HashSet<>();
        for (int node : conditions.keySet()) {
            if (dfs(node, new HashSet<>(), visited, conditions)) {
                return true;
            }
        }
        return false;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        for (int[] rowCondition : rowConditions) {
            rowConditionsMap.computeIfAbsent(rowCondition[0], v -> new HashSet<>()).add(rowCondition[1]);
        }

        if (isConditionsMapInvalid(rowConditionsMap)) {
            return new int[0][0];
        }

        for (int[] colCondition : colConditions) {
            colConditionsMap.computeIfAbsent(colCondition[0], v -> new HashSet<>()).add(colCondition[1]);
        }

        if (isConditionsMapInvalid(colConditionsMap)) {
            return new int[0][0];
        }

        for (int i = 1; i <= k; i++) {
            if (!rowConditionsMap.containsKey(i)) rowConditionsMap.put(i, new HashSet<>());
            if (!colConditionsMap.containsKey(i)) colConditionsMap.put(i, new HashSet<>());
        }

        int[][] res = new int[k][k];
        Map<Integer, Integer> colPos = new HashMap<>();
        for (int r = k - 1; r >= 0; r--) {
            int[] row = new int[k];
            int val = -1;
            for (int num : rowConditionsMap.keySet()) {
                if (rowConditionsMap.get(num).isEmpty()) {
                    val = num;
                    break;
                }
            }

            int col = k - 1;
            for (int next : colConditionsMap.get(val)) {
                if (colPos.containsKey(next)) {
                    col = Math.min(col, colPos.get(next) - 1);
                } else {
                    col--;
                }
            }
            colPos.put(val, col);
            row[col] = val;
            res[r] = row;

            for (int num : rowConditionsMap.keySet()) {
                rowConditionsMap.get(num).remove(val);
            }
            rowConditionsMap.remove(val);
        }
        return res;
    }
}

public class BuildAMatrixWithConditions_2392 {
    // Returns true if there is a loop
    private static boolean dfs(int node, Set<Integer> currPath, Set<Integer> visited, Map<Integer, Set<Integer>> adjSet, List<Integer> order) {
        if (currPath.contains(node))
            return true;

        if (visited.contains(node))
            return false;

        visited.add(node);
        currPath.add(node);
        if (adjSet.containsKey(node)) {
            for (int neighbor : adjSet.get(node)) {
                if (dfs(neighbor, currPath, visited, adjSet, order))
                    return true;
            }
        }
        currPath.remove(node);
        order.add(node);
        return false;
    }

    // perform DFS to find loop in the graph
    private static List<Integer> topologicalOrder(int[][] conditions, int k) {
        Map<Integer, Set<Integer>> adjSet = new HashMap<>();

        for(int[] condition: conditions){
            adjSet.computeIfAbsent(condition[0], v -> new HashSet<>()).add(condition[1]);
        }

        for(int i = 1; i <= k; i++){
            if(!adjSet.containsKey(i))
                adjSet.put(i, new HashSet<>());
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currPath = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        for (int node : adjSet.keySet()) {
            if (dfs(node, currPath, visited, adjSet, order)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(order);
        return order;
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalOrder(rowConditions, k);
        List<Integer> colOrder = topologicalOrder(colConditions, k);
        System.out.println(rowOrder);
        System.out.println(colOrder);

        if(rowOrder.isEmpty() || colOrder.isEmpty()) return new int[0][0];

        Map<Integer, Integer> rowPosMap = IntStream.range(0, rowOrder.size())
                .boxed()
                .collect(Collectors.toMap(rowOrder::get, i -> i));

        Map<Integer, Integer> colPosMap = IntStream.range(0, colOrder.size())
                .boxed()
                .collect(Collectors.toMap(colOrder::get, i -> i));

        int[][] res = new int[k][k];

        for (int num = 1; num <= k; num++) {
            int row = rowPosMap.get(num);
            int col = colPosMap.get(num);
            res[row][col] = num;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(buildMatrix(3, new int[][]{{1, 2}, {3, 2}}, new int[][]{{2, 1}, {3, 2}})));
//        System.out.println(Arrays.deepToString(buildMatrix(3, new int[][]{{1, 2}, {2, 3}, {3, 1}, {2, 3}}, new int[][]{{2, 1}})));
//        System.out.println(Arrays.deepToString(buildMatrix(8, new int[][]{{1, 2}, {7, 3}, {4, 3}, {5, 8}, {7, 8}, {8, 2}, {5, 8}, {3, 2}, {1, 3}, {7, 6}, {4, 3}, {7, 4}, {4, 8}, {7, 3}, {7, 5}}, new int[][]{{5, 7}, {2, 7}, {4, 3}, {6, 7}, {4, 3}, {2, 3}, {6, 2}})));
        System.out.println(Arrays.deepToString(buildMatrix(7,
                new int[][]{
                        {2, 4}, {1, 7}, {1, 4}, {7, 3}, {3, 4},
                        {5, 7}, {3, 4}, {1, 3}, {5, 7}, {6, 5},
                        {7, 3}, {6, 7}, {2, 4}, {1, 4}, {2, 7},
                        {3, 4}, {2, 7}, {6, 5}, {2, 7}, {7, 3}
                }, new int[][]{
                        {1, 6}, {1, 6}, {1, 7}, {4, 7}, {1, 6},
                        {7, 6}, {1, 5}, {5, 2}, {1, 2}, {3, 2},
                        {1, 4}
                })));
    }
}
