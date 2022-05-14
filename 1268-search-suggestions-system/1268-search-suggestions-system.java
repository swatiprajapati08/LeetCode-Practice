class Solution {
    public static class Node{
        boolean isEnd = false;
        Node children[] = new Node[26];
        
        public boolean isEnd(){
            return isEnd;
        }
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public void setChar(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
    }
    
    public void insert(Node root,String word){
        Node curr = root;
        
        for(char ch:word.toCharArray()){
            if(curr.contains(ch) == false)
                curr.setChar(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(Node root,String word){
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(curr.contains(ch) == false)
                return false;
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    public void DFS(Node root,String ssf,List<String> temp, int k){
        if(temp.size() == k) return;
        
        if(root.isEnd == true)
            temp.add(ssf);

        
        for(char c ='a'; c <= 'z'; c++){
            if(root.contains(c) == true){
                DFS(root.get(c),ssf + c,temp,k);
            }
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        
        for(String product : products)
            insert(root,product);
        // store the result
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i< searchWord.length();i++){
            char ch = searchWord.charAt(i);
            if(root.contains(ch) == true){
                root = root.get(ch);
                List<String> tempAns = new ArrayList<>();
                //add all words
                DFS(root,searchWord.substring(0,i + 1),tempAns,3);
                res.add(tempAns);
            }else
                break;
        }
        
        while(res.size() <searchWord.length())
            res.add(new ArrayList<>());
        
        return res;
    }
}