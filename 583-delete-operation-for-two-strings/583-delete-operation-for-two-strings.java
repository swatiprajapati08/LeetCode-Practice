class Solution {
    public int minDistance(String word1, String word2) {
      return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1,word2);
    }
     public  int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        return dp[m][n];
      }
}