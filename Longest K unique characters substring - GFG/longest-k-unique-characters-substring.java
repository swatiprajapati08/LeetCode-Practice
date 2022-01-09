// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int maxLength = -1;
        int left = 0;
        HashMap<Character,Integer> hs = new HashMap<>();
        for(int right = 0;right<s.length();right++){
            
            char ch = s.charAt(right);
            hs.put(ch,hs.getOrDefault(ch,0)+1);
            
            //invalid
             while(hs.size() > k){
                char chl = s.charAt(left);
                if(hs.get(chl) == 1)
                hs.remove(chl);
                else
                hs.put(chl,hs.get(chl) - 1);
                left++;
            }
            
            if(hs.size() == k)
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }
}