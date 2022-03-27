class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph,0,new boolean[graph.length],new ArrayList<>(),ans);
        return ans;
    }
    void dfs(int[][] graph, int src,boolean visited[],List<Integer> temp,List<List<Integer>> ans){
        if(src == graph.length - 1){
            temp.add(src);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        visited[src] = true;
        temp.add(src);
        for(int i:graph[src]){
            if(!visited[i]){
                dfs(graph,i,visited,temp,ans);
            }
        }
        //backtrack
        visited[src]= false;
        temp.remove(temp.size() - 1);
    }
}