// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<=N;i++)
            graph.add(new ArrayList<>());
        
        for(int i =0;i<Edges.size();i++){
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
          graph.get(u).add(v);
          graph.get(v).add(u);
        }
        boolean visited[] = new boolean[N + 1];
        for(int i= 1;i<= N;i++){
            if(!visited[i] && dfs(graph,visited,i,N,1))
                return true;
        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean visited[],int src,int n, int counter){
        
        visited[src] = true;
        
        if(n == counter)
        return true;
        
       
        for(int i:graph.get(src)){
            if(!visited[i] &&  dfs(graph,visited,i,n,counter + 1) )
                return true;
        }
        visited[src] = false;
        return false;
    }
} 