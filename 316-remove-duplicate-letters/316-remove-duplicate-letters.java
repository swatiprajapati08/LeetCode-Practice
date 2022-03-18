class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> q = new ArrayDeque<>();
        int freq[] = new int[26];
        boolean inQ[] = new boolean[26];
        
        for(char c:s.toCharArray())
            freq[c -'a']++;
        
        for(char c:s.toCharArray()){
            
            freq[c - 'a']--;
            if(inQ[c - 'a'] == true) continue;
            
            while(q.size() > 0 && q.getLast() > c && freq[q.getLast() - 'a'] > 0){
                inQ[q.removeLast() - 'a'] = false;
            }
            
            q.addLast(c);
            inQ[c -'a'] = true;
            
        }
        
        StringBuilder sb = new StringBuilder();
        while(q.size() > 0)
            sb.append(q.remove());
        
        return sb.toString();
    }
}