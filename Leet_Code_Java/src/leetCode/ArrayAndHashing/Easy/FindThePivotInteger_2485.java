package leetCode.ArrayAndHashing.Easy;

public class FindThePivotInteger_2485 {
    public int pivotInteger(int n) {
        int tot_sum = (n * (n + 1))/2;
        int rem_sum = 0;

        for(int num = n; num > 0; num--){
            if(tot_sum == rem_sum + num)
                return num;

            tot_sum -= num;
            rem_sum += num;
        }

        return -1;
    }
}
