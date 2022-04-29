// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        if(n == 1)
        return 2;
        
        int prev0 = 1 , prev1 = 1;
        
        for(int i = 2;i<=n;i++){
            int curr1 = prev0;
            int curr0 = (prev1 + prev0) % 1000000007;
            
            prev1 = curr1;
            prev0 = curr0;
        }
        return (prev1 + prev0) % 1000000007;
    }
}