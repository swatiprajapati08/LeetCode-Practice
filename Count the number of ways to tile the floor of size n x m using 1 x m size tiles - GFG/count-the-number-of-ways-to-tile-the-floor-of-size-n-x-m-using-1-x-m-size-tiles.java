// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String [] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.countWays(n, m);
            System.out.println(ans);         
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWays(int n, int m)
    {
        if(n < m) return 1;
        int dp[] = new int[n + 1];
        Arrays.fill(dp,1);
        for(int i = m;i<=n;i++){
            dp[i] = (dp[i - 1] + dp[i - m]) % 1000000007;
        }
        return dp[n];
    }
}