class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minDay = Integer.MAX_VALUE;
        for(int i:prices){
            profit = Math.max(profit, i - minDay);
            if(minDay > i){
                minDay = i;
            }
           
        }
        return profit;
    }
}