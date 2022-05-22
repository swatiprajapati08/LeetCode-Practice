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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int nums[], int n)  
	{  
	    int dp[] = new int[nums.length];
        
        
        int maxSum = 0;
        for(int i = 0; i < nums.length;i++){
            dp[i] = nums[i];
            // find all its prev index, if prev index element is smaller then current 
            
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i],dp[j] + nums[i]);
            }
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
	}  
}