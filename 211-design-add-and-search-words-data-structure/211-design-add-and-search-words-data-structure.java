class WordDictionary {
     static class Node{
        private boolean isEnd = false;
        private Node children[] = new Node[26];
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
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
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
          Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            
            char ch = word.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        return searchWord(word,0,root);
    }
    
    public boolean searchWord(String word,int index,Node curr){
        if(index == word.length())
            return curr.getEnd();
        
        char ch = word.charAt(index);
        if(ch == '.'){
            for(char chz ='a';chz <= 'z';chz++){
                if(!curr.contains(chz))
                    continue;
                 if(searchWord(word,index+1,curr.get(chz)))
                     return true;
            }
        }
        else{
            if(curr.contains(ch))
                return searchWord(word,index+1,curr.get(ch));
            else
                return false;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */