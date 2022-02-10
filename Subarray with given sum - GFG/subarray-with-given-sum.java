// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] nums, int n, int k) 
    {
        int left = 0,right = 0,sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(right < nums.length){
             sum += nums[right];
    
             while(sum > k){
                 sum -= nums[left];
                 left++;
             }
             if(sum == k){
                 ans.add(left + 1);
                 ans.add(right + 1);
                 return ans;
             }
             right++;
        }
        
        ans.add(-1);
        return ans;
    }
}