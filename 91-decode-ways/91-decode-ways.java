class Solution {
    public int numDecodings(String s) {
        int [] dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        return memo(dp,0,s);
    }
    int memo(int[] dp,int idx,String s){
        if(idx == s.length()) return 1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        if(s.charAt(idx) == '0') return 0;
        
        int single = memo(dp,idx + 1, s);
        int pair = idx + 1 < s.length() && Integer.parseInt(s.substring(idx,idx+2)) <= 26 ? memo(dp,idx + 2,s) : 0;
        return dp[idx] = single + pair;
    }
}