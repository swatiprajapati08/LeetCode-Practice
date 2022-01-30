class CustomStack {
    
   int arr[];
    int inc[];
    int top;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
        
    }
    
    public void push(int x) {
        if(top == arr.length - 1) return;
        top++;
        arr[top] = x;
        inc[top] = 0;
    }
    
    public int pop() {
        if(top == -1) return -1;
    
        int val = arr[top] + inc[top];
        
        if(top - 1 >= 0)
            inc[top - 1] += inc[top];
        
        inc[top] = 0;
        top--;
      return val;
    }
    
    public void increment(int k, int val) {
        if(top == -1)return;
        
        k = Math.min(k,top + 1);
        inc[k - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */