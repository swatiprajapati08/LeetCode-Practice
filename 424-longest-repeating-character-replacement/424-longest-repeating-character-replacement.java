class Solution {
    public int characterReplacement(String s, int k) {
    int max = 0;
        for(int i = 0; i<26;i++)
            max = Math.max(max,Repeating(s,k,(char)(i+'A')));
        return max;
    }
    public int Repeating(String s,int k, char ch){
        int left = 0;
        int max = 0,count = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            
            if(c != ch)
                count++;
            
            while(count > k){
                char chl = s.charAt(left);
                if(chl != ch)
                    count--;
                left++;
            }
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}