class Solution {
    public char findTheDifference(String s, String t) {
        
       if(s.length() == 0)
           return t.charAt(0);
        
        
        int freq[] = new int[26];
        int freq2[] = new int[26];
        for(char c:s.toCharArray())
            freq[c - 'a']++;
        
        for(char c:t.toCharArray()){
            freq2[c - 'a']++;
        }
        
        for(int i = 0;i<26;i++){
            if(freq[i] + 1 == freq2[i])
                return (char)(i + 'a');
        }
            
        return 'a';
    }
}