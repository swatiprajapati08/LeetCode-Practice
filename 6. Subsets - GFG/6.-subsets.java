// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       Helper(A,0,new ArrayList<Integer>(),res);
       Collections.sort(res,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> p, ArrayList<Integer> q){
            int i = 0;
            while(i < Math.min(p.size(), q.size())){
            if(p.get(i) == q.get(i)){
            i++;
            continue;
            }
            if(p.get(i) < q.get(i)){
            return -1;
            }
            return 1;
            }
            if(i < q.size()) return -1;
            if(i < p.size()) return 1;
            return 0;
            }
       });
       return res;
    }
    static void Helper(ArrayList<Integer> A,int index,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        if(index == A.size()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
         //include
        temp.add(A.get(index));
        Helper(A,index + 1,temp,res);
        temp.remove(temp.size()-1);
        
        //dont include
        Helper(A,index + 1,temp,res);
       
    }
}