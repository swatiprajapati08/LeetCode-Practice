// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = 1000000007;
    public long countFriendsPairings(int n) 
    { 
      long dp[] = new long[n + 1];
      Arrays.fill(dp,-1l);
      return memo(dp,n);
    }
    
    long memo(long dp[], int n){
        if(n == 0 || n == 1) return 1l;
        if(dp[n] != -1)
        return dp[n];
        
        long single = memo(dp,n - 1);
        long pair = ((n - 1) * memo(dp, n - 2)) % mod;
        
        return dp[n] = (single + pair) % mod;         
    }
    
}    
 