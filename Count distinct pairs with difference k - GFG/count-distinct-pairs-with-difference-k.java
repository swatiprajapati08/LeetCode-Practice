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
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int n, k;
            n = Integer.parseInt(S1[0]);
            k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            int ans = ob.TotalPairs(nums, k);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalPairs(int[] nums, int target)
    {
         Arrays.sort(nums);
        int i = 0, j = 1,ans = 0;
        while(i < nums.length && j < nums.length){
            
            if(i > 0 && i < nums.length && nums[i - 1] == nums[i]){i++; continue;}
            
            int diff = nums[j] - nums[i];
            
            if(i == j){
                if(target < 0)
                    i++;
                else
                    j++;
                continue;
            }
            
            if(diff == target){
                ans++;
                i++;
                j++;
            }
            else if(diff < target) j++;
            else
                i++;
        }
        return ans;
    }
}