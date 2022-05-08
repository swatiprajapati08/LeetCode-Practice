class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        
        for(int i = 1;i<prices.length;i++){
            
            //treating as buying day
            int newBuy = Math.max(buy,sell - prices[i]);
            
            //treating as selling day
            int newSell = Math.max(sell,buy + prices[i] - fee);
            
            sell = newSell;
            buy = newBuy;
            
        }
        return sell;
    }
}