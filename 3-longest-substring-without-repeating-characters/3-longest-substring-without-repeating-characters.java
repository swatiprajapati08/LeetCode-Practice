class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s== null)
            return 0;
        
        int i = 0, j = 1;
        HashSet<Character> hs = new HashSet<>();
        hs.add(s.charAt(0));
        
        int max = 1;
        while(i < j && j < s.length()){
            char curr = s.charAt(j);
            
            char  temp = curr;
            
            while(i < j && hs.contains(curr)){
               temp = s.charAt(i);
               hs.remove(temp);
                i++;
            }
            hs.add(curr);
                
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}