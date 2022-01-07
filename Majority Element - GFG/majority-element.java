// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size)
    {
         int count = 1;
        int val = nums[0];
        int i = 1;
        while(i < nums.length){
            if(val == nums[i]){
                count++;
            }
            else
                count--;
            
            if(count < 0){
                count = 1;
                val = nums[i];
            }
            i++;
        }
        int freq = 0;
        for(int j : nums){
            if(j == val)
                freq++;
        }
        if(freq > nums.length/2)
            return val;
        else
            return -1;
    }
}