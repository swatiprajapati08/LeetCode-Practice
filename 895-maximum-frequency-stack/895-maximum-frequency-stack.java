class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer,ArrayList<Integer>> value;
    int maxFreq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        value = new HashMap<>();   
    }
    
    public void push(int val) {
        
       freq.put(val,freq.getOrDefault(val,0) + 1);
        
       int getFreq = freq.get(val);
       if(value.containsKey(getFreq) == false){
           value.put(getFreq,new ArrayList<Integer>());
       }
       value.get(getFreq).add(val);
        if(getFreq > maxFreq)
            maxFreq = getFreq;
        
    }
    
    public int pop(){
       // int val = value.lastEntry().getKey(); //log n
       ArrayList<Integer> arr = value.get(maxFreq);
       int ans = arr.get(arr.size() - 1);
        
        //remove from array
        arr.remove(arr.size() - 1);
        if(arr.size() == 0){ value.remove(maxFreq); maxFreq--;}
        
       freq.put(ans,freq.get(ans) - 1);
      return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */