// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static HashMap<Integer,String> hs;
    static ArrayList <String> possibleWords(int a[], int N)
    {
        hs = new HashMap<>();
        hs.put(2,"abc"); hs.put(4,"ghi"); hs.put(5,"jkl"); hs.put(6,"mno"); 
        hs.put(3,"def"); hs.put(7,"pqrs"); hs.put(8,"tuv"); hs.put(9,"wxyz");
        
        ArrayList<String> res = new ArrayList<>();
        Helper(a,0,"",res);
        
        return res;
    }
    static void Helper(int a[],int idx, String curr,ArrayList<String> res){
        
        if(idx == a.length){
            res.add(curr);
            return;
        }
        
        String s = hs.get(a[idx]);
        for(int i = 0; i< s.length();i++)
        Helper(a,idx + 1,curr + s.charAt(i),res);
        
    }
}


