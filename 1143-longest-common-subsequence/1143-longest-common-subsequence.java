class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int dp[][] = new int[text1.length()][text2.length()];
        // for(int arr[] : dp)
        //     Arrays.fill(arr,-1);
        // return LCS(text1,0, text2,0,dp);
        
        int m = text1.length();
        int n = text2.length();
//         int dp[][] = new int[m + 1][n + 1];
        
//         for(int i= m ; i>= 0; i--){
//             for(int j =n ; j >= 0; j--){
//                 if(i == m || j == n)
//                     dp[i][j] = 0;
//                 else if(text1.charAt(i) == text2.charAt(j))
//                     dp[i][j] = 1 + dp[i + 1][j + 1];
//                 else
//                     dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
//             }
//         }
//         return dp[0][0];
        int []next = new int[text2.length() + 1];
         for(int i= m ; i>= 0; i--){
             int[] curr = new int[text2.length() + 1];
             
            for(int j =n ; j >= 0; j--){
                if(i == m || j == n)
                    curr[j] = 0;
                else if(text1.charAt(i) == text2.charAt(j))
                    curr[j] = 1 + next[j + 1];
                else
                    curr[j] = Math.max(next[j],curr[j + 1]);
            }
            next = curr;
         }
        return next[0];
    }
    
    int LCS(String text1,int i, String text2 , int j, int dp[][]){
        
        if(i == text1.length() || j == text2.length())
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // common character
        if(text1.charAt(i) == text2.charAt(j))
            dp[i][j] = 1 + LCS(text1, i + 1, text2,j + 1,dp);
        else
            dp[i][j] = Math.max(LCS(text1,i + 1,text2, j,dp), LCS(text1, i, text2, j + 1,dp));
        
        return dp[i][j];
    }
}