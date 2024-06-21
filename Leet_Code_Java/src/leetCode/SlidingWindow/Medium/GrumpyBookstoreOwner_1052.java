package leetCode.SlidingWindow.Medium;

public class GrumpyBookstoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int normCustomers = 0, grumpyCustomers = 0;
        int windowMax = -1, i = 0;

        for(int j = 0; j < customers.length; j++){
            if(grumpy[j] == 1)
                grumpyCustomers += customers[j];
            else
                normCustomers += customers[j];

            if(j - i + 1 > minutes){
                if(grumpy[i] == 1)
                    grumpyCustomers -= customers[i];
                i++;
            }
            windowMax = Math.max(windowMax, grumpyCustomers);
        }
        return windowMax + normCustomers;
    }
}
