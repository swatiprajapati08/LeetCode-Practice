class MapSum {
    HashMap<String,Integer> hs = new HashMap<>();
    
    static class Node{
        private int val = 0;
        private Node children[] = new Node[26];
        
        public int getVal(){
            return val;
        }
        
        public void setVal(int v){
            val += v;
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
    }
    Node root;
    public MapSum() {
        root = new Node();
    }

    
    public void insert(String word, int val) {
        
        int prevVal = val - hs.getOrDefault(word,0);
     
        hs.put(word,val);
        Node curr = root;
     
        for(int i = 0;i<word.length();i++){
            
            char ch = word.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr.setVal(prevVal);
            curr = curr.get(ch);
        }
        curr.setVal(prevVal);
       
    }
    
   public int sum(String word) {
           Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                return 0;
            curr = curr.get(ch);
        }
        return curr.getVal();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */