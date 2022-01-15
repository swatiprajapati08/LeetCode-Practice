class Solution {
     public static class Node{
        private Node[] children = new Node[26];
         boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
    }
   public void insert(Node curr,String word) {
       
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
       curr.isEnd = true;
    }
    
    String res ="";
    public void DFS(Node curr,String ans){
        int count = 0;
        if(ans.length() > res.length()){
            res = ans;
        }
        
        if(curr.isEnd == true)
            return;
        
        char child = 'a';
        for(char c ='a';c<='z';c++){
            if(curr.contains(c)==true){
                count++;
                child = c;
            }
        }
        
        if(count == 1) DFS(curr.get(child),ans+child);

    }
    
    
    
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        
        for(String s:strs){
            insert(root,s);
        }
        
        DFS(root,"");
        return res;
        
    }
}