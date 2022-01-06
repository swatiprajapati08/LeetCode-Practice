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
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        long[] ans = new long[N - K + 1];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<K;i++){
            if(arr[i] < 0)
            q.add(i);
        }
        int p = 0;
        ans[p++] = q.size() == 0 ? 0 : arr[q.peek()];
        for(int i = K; i<N;i++){
            
            if(q.size() > 0 && arr[i - K] == arr[q.peek()])
            q.remove();
            
            if(arr[i] < 0)
            q.add(i);
            
            ans[p++] = q.size() == 0 ? 0 : arr[q.peek()];
        }
        return ans;
    }
}