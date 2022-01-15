class Solution {
    
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
    
   public void insert(Node root,String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public String search(Node root,String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.getEnd() == true)
                return word.substring(0,i);

            if(curr.contains(ch) == false)
                return word;
        
            curr = curr.get(ch);
        }
        
        return word;
    }
    
    
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        for(String s:dict){
            insert(root,s);
        }
        
        String arr[] = sentence.split(" ");
        StringBuilder sb=new StringBuilder("");
        boolean flag = false;
        for(String s:arr){
            if(sb.length() > 0)  sb.append(" ");
           sb.append(search(root,s));
        }
        
        return sb.toString();
        
    }
}