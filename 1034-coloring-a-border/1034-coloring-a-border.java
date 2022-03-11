class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
        for(int i =0;i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++)
                grid[i][j] = grid[i][j] < 0 ? color : grid[i][j];
        }
        return grid;
    }
    
    void dfs(int [][]grid,int row, int col,int oldColor){
        //negative case if not border
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
           grid[row][col] != oldColor)
            return;
        
        grid[row][col] = -oldColor;
        dfs(grid,row + 1,col,oldColor);
        dfs(grid,row - 1,col,oldColor);
        dfs(grid,row,col + 1,oldColor);
        dfs(grid,row,col - 1,oldColor);
        
        // if that is inside or not boundary make it positive
        if(row > 0 && row < grid.length - 1  && col > 0 && col < grid[0].length - 1
            && oldColor == Math.abs(grid[row + 1][col])
            && oldColor == Math.abs(grid[row - 1][col])
            && oldColor == Math.abs(grid[row][col + 1])
            && oldColor == Math.abs(grid[row][col - 1]))
            grid[row][col] = oldColor;
        
        
        return;
    } 
}