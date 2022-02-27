class Solution {
    public int closedIsland(int[][] grid) {
        //boundary vale ko hata do
        for(int i = 0;i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i * j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
                    if(grid[i][j] == 0)
                        dfs(grid, i ,j);
                }
            }
        }
        int count = 0;
      for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                    if(grid[i][j] == 0){
                        dfs(grid, i ,j);
                        count++;
                }
            }
      }
        return count;
    }
    
    void dfs(int grid[][], int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        dfs(grid, i + 1,j);
        dfs(grid,i - 1,j);
        dfs(grid,i, j + 1);
        dfs(grid,i, j - 1);
        return;
    }
}