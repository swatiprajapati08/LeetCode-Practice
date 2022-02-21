class Solution {
    public int findCircleNum(int[][] arr) {
        int count = 0;
        boolean visited[] = new boolean[arr.length];
        for(int i  = 0; i < arr.length;i++)
        {
                if(!visited[i]){
                    dfs(i,visited,arr);
                    count++;
                }
            
        }
      return count;
    }
    //dfs on marix
  public void dfs(int i, boolean[] visited, int arr[][]){
        visited[i] = true;

        for(int k = 0 ; k < arr.length;k++){
            if(arr[i][k] == 1 && !visited[k])
                dfs(k,visited,arr);
        }
    }
}