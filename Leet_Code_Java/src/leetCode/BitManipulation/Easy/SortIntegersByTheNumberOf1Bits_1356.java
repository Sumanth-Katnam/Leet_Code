package leetCode.BitManipulation.Easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortIntegersByTheNumberOf1Bits_1356 {
    public static int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> bitCountMap = new HashMap<>();
        Arrays.sort(arr);

        int bitCount;
        for(int num: arr){
            bitCount = Integer.bitCount(num);
            bitCountMap.computeIfAbsent(bitCount,v -> new ArrayList<>()).add(num);
        }

        List<Integer> sortedList = bitCountMap.keySet().stream().sorted().toList();
        List<Integer> res = new ArrayList<>();
        for(int cnt: sortedList){
            res.addAll(bitCountMap.get(cnt));
        }
        
        return res.stream().mapToInt(i -> i).toArray();
//        List<Integer> sortedList = Arrays.stream(arr)
//                .boxed()
//                .sorted(Comparator.comparingInt(Integer::bitCount)).collect(Collectors.toList());
//        Collections.reverse(sortedList);
//        return sortedList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }
}
