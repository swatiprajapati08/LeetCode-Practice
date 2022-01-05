// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        return m + n - longestCommonSubsequence(X,Y);
    }
     public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        //printing LCS
        StringBuilder sb = new StringBuilder();
        int index1 = m , index2 = n;
        while(index1 > 0 && index2 > 0){
            if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)){
                sb.append(text1.charAt(index1 - 1));
                index1--;
                index2--;
            }
            else{
                //do not match
                if(dp[index1 - 1][index2] > dp[index1][index2-1])
                    index1--;
                else
                    index2--;
            }
        }
        //System.out.println(sb.reverse().toString());
        
        
        return dp[m][n];
    }
}