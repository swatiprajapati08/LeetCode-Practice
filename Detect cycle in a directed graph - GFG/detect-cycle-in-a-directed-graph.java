// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean visited[] = new boolean[V];
      boolean extra[] = new boolean[V];
      
      for(int i =0;i< V;i++){
          if(!visited[i]){
             if(dfs(i,visited,extra,adj))
             return true;
          }
      }
    return false;
    }
    
    boolean dfs(int s,boolean visited[], boolean extra[],ArrayList<ArrayList<Integer>> adj){
        visited[s] = true;
        extra[s] = true; // mark them true
        
        // explore neighbour
 
        for(int i:adj.get(s)){
            if(!visited[i]){
              if(dfs(i,visited,extra,adj))
                  return true;
            } else if(extra[i] == true)
                return true;
        }
        //backtrack
        extra[s] = false;
        
    return false;
    }
}