class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        //pop smaller
        int count=1;
        
        
        
        while(st.size() > 0 && price >= st.peek()[0]){
            count += st.peek()[1];
            st.pop();
        }
        // adding back in stack
        
        st.push(new int[]{price,count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */