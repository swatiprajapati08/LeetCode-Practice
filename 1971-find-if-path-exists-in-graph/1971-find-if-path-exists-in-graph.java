class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++)
            graph[i] = new ArrayList<>();
        
        for(int i =0;i<edges.length;i++){
            int src = edges[i][0];
            int nbr = edges[i][1];
            graph[src].add(nbr);
            graph[nbr].add(src);
        }
        boolean visited[] = new boolean[n];
        return dfs(graph,visited,source,destination);
    }
    boolean dfs(ArrayList<Integer> graph[],boolean visited[],int src, int des){
        if(src == des)
            return true;
        visited[src] = true;
        boolean ans = false;
        for(int i:graph[src]){
            if(!visited[i])
                ans = ans || dfs(graph,visited,i,des);
        }
        return ans;
    }
}