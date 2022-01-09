// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String findSubString( String str) {
       HashMap<Character, Integer> req = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();
        
        
        for(char c: str.toCharArray())
            req.put(c,1);
        
        int left = 0;
        char ch[] = str.toCharArray();
        int count = 0,maxCount = Integer.MAX_VALUE;
        int start = 0;
       for(int right = 0; right < str.length(); right++){
        
            char c = ch[right];
            curr.put(c, curr.getOrDefault(c,0) + 1);
            
            if(curr.get(c) == req.getOrDefault(c,0))
                count++;
            
            while(count >= req.size()){
                
                if(count >= req.size() && maxCount > right - left){
                    maxCount = right - left + 1;
                    start = left;
                }
                
                char chl = ch[left];
                
                
                
                if(curr.get(chl) == req.getOrDefault(chl,0))
                    count--;
                    
                 curr.put(chl,curr.get(chl) - 1);
                left++;
            }
        }
        if(maxCount == Integer.MAX_VALUE) return "";
        return str.substring(start , start + maxCount);
    }
}