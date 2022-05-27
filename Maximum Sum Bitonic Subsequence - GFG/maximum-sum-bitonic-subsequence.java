// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[],int n)
    {
        //int n = arr.length;
        int LISlr[] = new int[n];
        
        for(int i = 0; i< n;i++){
            LISlr[i] = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i])
                    LISlr[i] = Math.max(LISlr[j] + arr[i],LISlr[i]);
            }
        }
        
        // right to left
        int LISrl[] = new int[n];
        for(int i = n - 1; i >=0 ;i--){
            LISrl[i] = arr[i];
            for(int j = n - 1; j > i; j--){
                if(arr[i] > arr[j])
                    LISrl[i] = Math.max(LISrl[j] + arr[i], LISrl[i]);
            }
        }
        
       // Longest Bitonic Subsequence with peak at index i
        // = LIS ending at i + LDS starting at i - 1
        // -1 represents the peak element occuring in both LIS and LDS
        // Constraint: LIS > 1 && LDS > 1 (Alteast 1 element to the left of peak
        // and atleast 1 element to the right of peak)
        int maxBitonic = 0;
        for (int i = 0; i < n; i++) {
            int curr = LISlr[i] + LISrl[i] - arr[i];
            //if (LISlr[i] > 1 && LISrl[i] > 1) {
                maxBitonic = Math.max(maxBitonic, curr);
            //}
        }

        return maxBitonic; 
    }
}