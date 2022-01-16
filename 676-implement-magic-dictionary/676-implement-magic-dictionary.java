class MagicDictionary {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    Node root;

    public MagicDictionary() {
         root = new Node();
    }
    
    public void addWord(String word) {
         Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);

            curr = curr.get(ch);
        }

        curr.setEnd();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s:dictionary)
            addWord(s);
    }
    
    public boolean search(String word) {
        return searchWord(word,0,root,false);
    }
    public boolean searchWord(String word,int idx,Node curr,boolean change){
        
        if(word.length() == idx){
            if(curr.getEnd() == true && change == true)
                return true;
            else
                return false;   
        }
        
        char ch = word.charAt(idx);
        if(curr.contains(ch)==true && searchWord(word,idx + 1,curr.get(ch),change) == true)
             return true;
        
            //search in all character
            if(change == true)
                return false;
            
            for(char chz = 'a'; chz <= 'z';chz++){
                
                if(chz == ch) continue;
                
                if(curr.contains(chz) && searchWord(word,idx + 1,curr.get(chz),true) == true){
                    return true;
                }
            }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */