package leetCode.TwoPointers.Medium;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0, j = people.length - 1;

        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            res++;
        }
        return res;
    }
}
