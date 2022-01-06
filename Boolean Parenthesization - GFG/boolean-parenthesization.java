// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        // code here
      int dp[][][] = new int[N + 1][N + 1][2];

        for (int row[][] : dp)
            for (int col[] : row)
                Arrays.fill(col, -1);
        
        return solve(S.toCharArray(),0,N-1,1,dp);
    }
    static int solve(char[] arr, int i, int j,int isTrue, int[][][] dp){
        
        if(i > j ) // "" or F
        return 0;
        
        if(i == j){
            
            if(isTrue == 1)
            return arr[i] == 'T' ? 1 : 0;
            else
            return arr[i] == 'F' ? 1 : 0;
        }
        
        if(dp[i][j][isTrue] != -1)
        return dp[i][j][isTrue];
        
        int ans = 0;
        int tempAns = 0;
        
        for(int k = i + 1; k <= j - 1; k = k + 2){
         
         int lF = dp[i][k - 1][0] != -1 ? dp[i][k - 1][0] : solve(arr,i, k - 1,0,dp);
         int lT = dp[i][k - 1][1] != -1 ? dp[i][k - 1][1] : solve(arr,i, k - 1,1,dp);
         int rF = dp[k + 1][j][0] != -1 ? dp[k + 1][j][0] : solve(arr,k + 1, j,0,dp);
         int rT = dp[k + 1][j][1] != -1 ? dp[k + 1][j][1] : solve(arr,k + 1, j,1,dp);
         
         //evaluate ans 

         
         if(arr[k] == '&'){
             
             if(isTrue == 1)
             tempAns += rT * lT;
             else
             tempAns += lT * rF + lF * rT + lF * rF;
         }
         else if(arr[k] == '|'){
             
             if(isTrue == 1)
             tempAns += lT * rF + lT * rT + lF * rT;
             else
             tempAns += lF * rF;
         }
         else if(arr[k] == '^'){
             
             if(isTrue == 1)
             tempAns += lF * rT + lT * rF;
             else
             tempAns += lF * rF + lT * rT;
         }
         dp[i][j][isTrue] = tempAns % 1003;
        }
        return dp[i][j][isTrue];
    }
}