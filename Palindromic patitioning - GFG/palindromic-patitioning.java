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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][];
    static int palindromicPartition(String str)
    {
        dp = new int[501][501];
        
        for(int i = 0; i< dp.length;i++)
        Arrays.fill(dp[i],-1);
        
        return solve(str.toCharArray(),0,str.length() - 1);
    }
    static int solve(char[] arr, int i, int j){
        if(i >= j || isPalindrome(arr,i,j))
        return 0;
        
        if(dp[i][j] != -1)
        return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++){
            
           int left = dp[i][k] != -1 ? dp[i][k] : solve(arr,i,k);
           int right = dp[k + 1][j] != -1 ? dp[k + 1][j] : solve(arr,k + 1, j);
           
           int tempAns = 1 + left + right;
           
           min = Math.min(min,tempAns);
        }
        dp[i][j] = min;
        
        return min;
    }
    
    static boolean isPalindrome(char[] arr,int i, int j){
        if(i == j)
        return true;
        
        while(i < j){
            if(arr[i] != arr[j])
            return false;
            i++;
            j--;
        }
        return true;
    }
}