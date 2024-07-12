package leetCode.Graphs.Medium;

import java.util.*;

public class CourseScheduleII_210 {
    static List<Integer> res = new ArrayList<>();
    static Set<Integer> currPath = new HashSet<>();
    static Set<Integer> visited = new HashSet<>();
    private static boolean dfs(Set<Integer> currPath, Set<Integer> visited, Map<Integer, List<Integer>> preReqMap, int course){
        if(currPath.contains(course)) return false;
        if(visited.contains(course)) return true;

        currPath.add(course);
        if(preReqMap.containsKey(course)){
            for(int depCourse: preReqMap.get(course)){
                if(!dfs(currPath, visited, preReqMap, depCourse))
                    return false;
            }
        }
        currPath.remove(course);
        visited.add(course);
        res.add(course);
        return true;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for(int[] req: prerequisites){
            if(!preReqMap.containsKey(req[0])){
                preReqMap.put(req[0], new ArrayList<>());
            }
            preReqMap.get(req[0]).add(req[1]);
        }

        for(int course = 0; course < numCourses; course++){
            if(!dfs(currPath, visited, preReqMap, course)) return new int[0];
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(1, new int[][]{{}})));
    }
}
