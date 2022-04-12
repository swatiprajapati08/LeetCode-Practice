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
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minSteps(int n) 
	{ 
	    if(n <= 3){
	        if(n <= 1)
	        return 0;
	        else
	        return 1;
	    }
	    int dp[] = new int[n + 1];
	    dp[0] = 0 ;dp[1] = 0;
	    dp[2] = 1 ;dp[3] = 1;
	    
	    for(int i = 4; i<=n;i++){
	        int div3 = i % 3 == 0 ? dp[i / 3] : Integer.MAX_VALUE;
	        int div2 = i % 2 == 0 ? dp[i / 2] : Integer.MAX_VALUE;
	        dp[i] = 1 + Math.min(dp[i - 1],Math.min(div2,div3));
	    }
	    return dp[n];
	} 
}
