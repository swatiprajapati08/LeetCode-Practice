class Solution {
    public int minInsertions(String s) {
         StringBuffer sbr = new StringBuffer(s);
        // To reverse the string
        sbr.reverse(); 
        String t = sbr.toString();
        
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = t.length() - 1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
            }
        }
        return s.length() - dp[0][0];
    }
}