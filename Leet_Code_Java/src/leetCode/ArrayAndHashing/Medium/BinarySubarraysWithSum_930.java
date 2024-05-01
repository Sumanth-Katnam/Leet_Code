package leetCode.ArrayAndHashing.Medium;

public class BinarySubarraysWithSum_930 {
//    public int numSubarraysWithSum(int[] nums, int goal) {
//        Map<Integer, Integer> cnt_map = new HashMap<>();
//        cnt_map.put(0, 1);
//        int curr_sum = 0;
//        int res = 0;
//
//        for(int num : nums){
//            curr_sum += num;
//            if(cnt_map.containsKey(curr_sum - goal))
//                res += cnt_map.get(curr_sum - goal);
//            cnt_map.put(curr_sum, cnt_map.getOrDefault(curr_sum, 0) + 1);
//        }
//
//        return res;
//    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        int head, tail = 0, sum = 0, result = 0;
        for (head = 0; head < nums.length; head++) {
            sum += nums[head];
            while (sum > goal && tail <= head) {
                sum -= nums[tail];
                tail++;
            }
            result += head - tail + 1;
        }
        return result;
    }
}
