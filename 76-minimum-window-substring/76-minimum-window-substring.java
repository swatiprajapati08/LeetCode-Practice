class Solution {
    public String minWindow(String st, String t) {
        
         if(t.equals("") == true || st.equals("") == true 
                    || st.length() < t.length()) return "";
        
        HashMap<Character, Integer> req = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();
        
        
        for(char c: t.toCharArray())
            req.put(c,req.getOrDefault(c,0) + 1);
        
        int left = 0;
        char ch[] = st.toCharArray();
        int count = 0,maxCount = Integer.MAX_VALUE;
        int start = 0;
       for(int right = 0; right < st.length(); right++){
        
            char c = ch[right];
            curr.put(c, curr.getOrDefault(c,0) + 1);
            
            if(curr.get(c).equals(req.getOrDefault(c,0)) == true)
                count++;
            
            while(count >= req.size()){
                if(count >= req.size() && maxCount > right - left){
                    maxCount = right - left + 1;
                    start = left;
                }
                
                char chl = ch[left];
                
                
                
                if(curr.get(chl).equals(req.getOrDefault(chl,0)) == true)
                    count--;
                 curr.put(chl,curr.get(chl) - 1);
                left++;
            }
        }
        if(maxCount == Integer.MAX_VALUE) return "";
        return st.substring(start , start + maxCount);
    }
}