class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.length() == k)
            return "0";
        
        Deque<Character> q = new ArrayDeque<>();
        int reqSize = num.length() - k;
        
        for(int i = 0;i<num.length();i++){
            char c = num.charAt(i);

            while(q.size() > 0 && q.getLast() > c && k > 0){
                q.removeLast();
                k--;
            }
            q.addLast(c);  
        }
        
        StringBuilder sb = new StringBuilder();
        
        // k>0 even though whole string processed
        while(q.size() > 0 && k>0){
            q.removeLast();
            k--;
        }
        //remove leading zeros
        while(q.size() > 0 && q.getFirst() == '0'){
            q.removeFirst();
        }
        
        if(q.size() == 0) return "0";
     
        while(q.size() > 0)
            sb.append(q.remove());
        
        return sb.toString();
    }
}