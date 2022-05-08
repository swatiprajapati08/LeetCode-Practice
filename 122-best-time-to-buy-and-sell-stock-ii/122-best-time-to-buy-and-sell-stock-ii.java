class Solution {
    public int maxProfit(int[] prices) {
        //using stack
        // int profit = 0;
        // Stack<Integer> st = new Stack<>();
        // for(int buyDay:prices){
        //     if(st.size() > 0 && st.peek() < buyDay)
        //         profit += buyDay - st.pop();
        //   st.push(buyDay);
        // }
        
    //     //using extra variable
    //     int profit = 0;
    //     int top = 0;
    //     for(int buyDay:prices){
    //         if(top <buyDay)
    //             profit += buyDay -top;
    //       top =buyDay;
    //     }
    // return profit;
        
         int buy = -prices[0];
        int sell = 0;
        
        for(int i = 1;i<prices.length;i++){
            
            //treating as buying day
            int newBuy = Math.max(buy,sell - prices[i]);
            
            //treating as selling day
            int newSell = Math.max(sell,buy + prices[i]);
            
            sell = newSell;
            buy = newBuy;
            
        }
        return sell;
    }
}