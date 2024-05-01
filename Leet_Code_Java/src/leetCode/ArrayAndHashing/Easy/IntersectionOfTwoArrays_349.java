package leetCode.ArrayAndHashing.Easy;

import java.util.*;

public class IntersectionOfTwoArrays_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
//        List<Integer> res = new ArrayList<>();
//        Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
//
//        for(Integer num: n1){
//            if(n2.contains(num)){
//                res.add(num);
//            }
//        }
//
//        return res.stream().mapToInt(num -> num).toArray();

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int j : nums1) {
            set.add(j);
        }

        for (int j : nums2) {
            if (set.contains(j)) {
                list.add(j);
            }
            set.remove(j);
        }

        int[] arr = new int[list.size()];

        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
