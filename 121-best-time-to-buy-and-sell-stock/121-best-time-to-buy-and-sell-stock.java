class Solution {
    public int maxProfit(int[] prices) {
        //potential buying day
        //find its selling day from its i to n(max )
        int max = prices[prices.length - 1];
        int profit = 0;
        for(int i = prices.length - 1; i>=0;i--){
            max = Math.max(prices[i],max);
            profit = Math.max(profit, max - prices[i]);
            
        }
        return profit;
    }
}