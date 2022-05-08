class Solution {
    public int maxProfit(int[] prices) {
        //using stack
        int profit = 0;
        Stack<Integer> st = new Stack<>();
        for(int buyDay:prices){
            if(st.size() > 0 && st.peek() < buyDay)
                profit += buyDay - st.pop();
          st.push(buyDay);
        }
    return profit;
    }
}