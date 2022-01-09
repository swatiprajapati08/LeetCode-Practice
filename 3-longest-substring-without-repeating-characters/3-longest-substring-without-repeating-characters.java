class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        
        int left = 0, right = 0;
        char ch[] = s.toCharArray();
        int max = 0;
        while(left < s.length() && right < s.length()){
            
            freq.put(ch[right],freq.getOrDefault(ch[right],0) + 1);
            
            //invalid 
            while(freq.get(ch[right]) > 1){
                char chl = ch[left];
                freq.put(chl,freq.get(chl) - 1);
                left++;
            }
                
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}