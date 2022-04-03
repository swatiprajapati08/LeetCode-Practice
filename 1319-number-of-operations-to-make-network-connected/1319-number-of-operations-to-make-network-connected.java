class Solution {
    public int makeConnected(int n, int[][] connections) {
        boolean visited[] = new boolean[n];
        int comp = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(new ArrayList<Integer>());
        
        for(int[] i:connections){
            // add the connection
            arr.get(i[0]).add(i[1]);
            arr.get(i[1]).add(i[0]);
        }
        
        for(int i = 0; i< n;i++){
            if(!visited[i]){
                dfs(arr,i,visited);
                comp++;
            }
        }
       return connections.length >= n - 1 ? comp - 1 : -1;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> arr, int src,boolean visited[]){
        visited[src] = true;
        for(int nbr : arr.get(src)){
            if(!visited[nbr])
                dfs(arr,nbr,visited);
        }
    }
    
}