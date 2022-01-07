class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words.length == 0)
            return new ArrayList<>();
        
        HashMap<String,Integer> freq = new HashMap<>();
        
        for(String word: words)
            freq.put(word,freq.getOrDefault(word,0) + 1);
        
        int n = words.length;
        int wordLen = words[0].length();
        List<Integer> ans = new ArrayList<>();
        
        for(int i= 0; i < s.length() - n * wordLen + 1;i++){
            
            String temp = s.substring(i,i+n * wordLen);
            if(Helper(temp,freq,wordLen))
                ans.add(i);
        }
        return ans;
    }
    
    boolean Helper(String temp,HashMap<String,Integer> freq,int wordLen){
        
        HashMap<String,Integer> freq2 = new HashMap<>();
        for(int i =0; i<temp.length();i+=wordLen){
            String word = temp.substring(i,i+wordLen);
            freq2.put(word,freq2.getOrDefault(word,0) + 1);    
        }
        
        return freq.equals(freq2);
    }
    
}