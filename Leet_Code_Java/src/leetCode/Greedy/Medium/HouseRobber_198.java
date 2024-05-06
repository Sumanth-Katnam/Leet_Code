package leetCode.Greedy.Medium;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        int rob1, rob2;
        rob1 = rob2 = 0;
        int tempRob;
        for(int num: nums){
            tempRob = Math.max(rob2 + num, rob1);
            rob2 = rob1;
            rob1 = tempRob;
        }

        return rob1;
    }
}
