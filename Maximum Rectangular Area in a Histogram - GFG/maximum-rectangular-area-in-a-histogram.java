// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long n) 
    {
        //next smaller to left
        int nsl[] = new int[(int)n];
        int nsr[] = new int[(int)n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < (int)n;i++){
            //pop 
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
             // make ans
            if(st.size() > 0)
                nsl[i] = st.peek();
            else nsl[i] = -1;
            // push yourself
            
            st.push((int)i);
        }
        // for(int i:nsl)
        //     System.out.print(i+" ");
        //next smaller to right
         st = new Stack<>();
        for(int i = (int)n - 1; i >= 0;i--){
            //pop 
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
             // make ans
            if(st.size() > 0)
                nsr[i] = st.peek();
            else nsr[i] = (int)n;
            // push yourself
            
            st.push((int)i);
        }
        
//         for(int i:nsr)
//             System.out.print(i+" ");
        
        long max = 0;
        //for each element nsr - nsl - 1 * nums[i]
        
        for(int i =0;i<n;i++){
            long val = (nsr[i] - nsl[i] - 1) * heights[i];
            max = Math.max(val,max);
         }
        return max;
    }
}



