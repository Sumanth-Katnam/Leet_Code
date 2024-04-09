package leetCode.ArrayAndHashing;

public class TimeNeededToBuyTickets_2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        for(int idx = 0; idx < tickets.length; idx++){
            if(idx <= k)
                res += Math.min(tickets[idx], tickets[k]);
            else
                res += Math.min(tickets[idx], tickets[k] - 1);
        }
        return res;
    }
}
