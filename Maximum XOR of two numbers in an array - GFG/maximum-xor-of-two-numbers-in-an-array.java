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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[n];
            for(int i = 0; i < n; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
           System.out.println(ob.max_xor(v, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
        public static class Node{
        Node left;
        Node right;
    }
    public static void insert(Node root,int val){
        for(int i= 31;i>=0;i--){
            //get bit
            int bit = val & (1 << i);
            
            if(bit == 0){
                if(root.left == null)
                    root.left = new Node();
                root = root.left;
            }
            else{
                if(root.right == null)
                    root.right = new Node();
                root = root.right;
            }
        }
    }
    
    public static int search(Node root,int val){
        int maxXor = 0;
        for(int i = 31; i>=0;i--){
            
            int bit = val & (1 << i);
            
            if(bit == 0){
                //we want 1 to get maxXor = 1
                //if we get then move to that 
                if(root.right != null){
                    root = root.right;
                    //set that bit in maxXor
                    maxXor = maxXor | (1 << i);
                }else
                    root = root.left;
            }
            else{
                //we want 0 to get maxXor = 1
                if(root.left != null){
                    root = root.left;
                    maxXor = maxXor | (1 << i);
                }
                else
                    root = root.right;
            }
        }
        return maxXor;
    }
    public static int max_xor(int arr[], int n)
    {
      Node root = new Node();
        
        int ans = 0;
        for(int val : arr){
            insert(root,val);
            ans = Math.max(ans,search(root,val));
        }
        return ans;  
    }
}