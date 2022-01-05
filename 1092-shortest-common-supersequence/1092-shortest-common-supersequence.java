class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
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
        //printing LCS
        StringBuilder sb = new StringBuilder();
        int index1 = m , index2 = n;
        while(index1 > 0 &&  index2 > 0){
            if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)){
                sb.append(text1.charAt(index1 - 1));
                index1--;
                index2--;
            }
            else{
                //do not match
               
                
                if(dp[index1 - 1][index2] > dp[index1][index2-1]){
                    sb.append(text1.charAt(index1 - 1));
                    index1--;
                } 
                else{
                    sb.append(text2.charAt(index2 - 1));
                    index2--;
                }
            }
        }
        
        while(index1 > 0){
             sb.append(text1.charAt(index1 - 1));
                    index1--;
        }
        while(index2 > 0){
              sb.append(text2.charAt(index2 - 1));
                    index2--;
        }
        return (sb.reverse().toString()); 
    }
}