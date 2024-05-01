package leetCode.SlidingWindow.Easy;

public class BestTimeToBuyAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int min= prices[0];
        int profit, currentProfit;
        profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(min > prices[i]) {
                min = prices[i];
            }
            currentProfit = prices[i] - min;
            if(profit < currentProfit)
                profit = currentProfit;
        }
        return profit;
    }

    public static void main(String args[]){
        maxProfit(new int[]{2,4,1});
    }
}
