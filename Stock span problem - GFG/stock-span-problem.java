// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
         Stack<Integer> st = new Stack<Integer>();
        int stock[] = new int[n];
        for(int i=0;i<n;i++){
            
            //pop all smaller
            while(st.size() > 0 && price[i] >= price[st.peek()])
            st.pop();
            
            if(st.size() > 0)
            stock[i] = i - st.peek();
            else
            stock[i] = i + 1;
            
            st.push(i);
        }
        return stock;
    }
}