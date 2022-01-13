// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	Stack<Integer> potentialCeleb = new Stack<Integer>();

        for(int i=0; i<arr.length;i++)
        potentialCeleb.push(i);
        
        while(potentialCeleb.size() > 1)
        {
            int val2 = potentialCeleb.pop();
            int val1 = potentialCeleb.pop();
            //System.out.println(val2+" "+val1);
            if(arr[val1][val2] == 1)
            //val1 janta hai val2 => val1 reject
            potentialCeleb.push(val2);
            else
            //val1 ni janta hai val2  => reject val2
            potentialCeleb.push(val1);
            
        }
        if(checkValid(arr,potentialCeleb.peek()))
        return potentialCeleb.peek();
        else
        return -1;
    }
    
    static boolean checkValid(int arr[][],int index)
    {
        //check row it must have zer0(celebrity doesn't know anyone)
        for(int i = 0; i < arr.length; i++)
        {
            if( index != i && arr[index][i] == 1)
            return false;
        }
        //check column it must have one (everybody know celebrity)
        for(int i = 0; i < arr.length; i++)
        {
            if( index != i && arr[i][index] == 0)
            return false;
        }
        return true;
    }
}