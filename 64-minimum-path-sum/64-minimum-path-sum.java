class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = m-1;i>= 0;i--){
            for(int j = n-1;j>=0;j--){
                //last grid
                if(i == m - 1 && j == n - 1) continue;
                
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i + 1 < m) 
                    down = grid[i + 1][j];
                if(j + 1 < n)
                    right = grid[i][j + 1];
             grid[i][j] += Math.min(down,right);
            }
        }
        return grid[0][0];
    }
}