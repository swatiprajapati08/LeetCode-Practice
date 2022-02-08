class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int freq[] = new int[26];
        for(char ch:s.toCharArray())
            freq[ch - 'a']++;
        
        HashSet<Character> hs = new HashSet<>();
        
        for(char ch:s.toCharArray()){
            //remove the 
            freq[ch - 'a']--;
            if(hs.contains(ch)) continue;
            
            while(st.size() > 0 && st.peek() > ch){
                if(freq[st.peek() - 'a'] > 0){
                    hs.remove(st.peek());
                    st.pop();
                }else{
                    break;
                }
            }
            
            //push yourself
                st.push(ch);
                hs.add(ch); 
           
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0)
            sb.append(st.pop());
        
        return sb.reverse().toString();
    }
}