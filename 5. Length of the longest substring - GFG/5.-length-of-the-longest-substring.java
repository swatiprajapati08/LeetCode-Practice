// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int left = 0, right = 0,max=0;
        HashMap<Character,Integer> hs = new HashMap<>();
        while(right < S.length()){
            char ch = S.charAt(right);

            hs.put(ch,hs.getOrDefault(ch,0)+1);
            while(hs.get(ch) > 1){
                char chl = S.charAt(left);
                if(hs.get(chl)==1)
                hs.remove(chl);
                else
                hs.put(chl,hs.get(chl)-1);
                left++;
            }
                     
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}