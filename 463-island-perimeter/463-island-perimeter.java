class Solution {
    public int islandPerimeter(int[][] grid) {
        int landCell = 0, overlapping  = 0;
        for(int i =0;i < grid.length; i++){
            for(int j = 0; j< grid[0].length;j++){
                if(grid[i][j] == 1){
                    landCell++;
                    boolean right = (j != grid[0].length - 1); // check its right exist o not
                    boolean down = (i != grid.length - 1);
                    
                    if(!right && !down)
                        continue;
                    else if(right == true && down == false){
                        if(grid[i][j + 1] == 1)
                            overlapping++;
                    }else if(right == false && down == true){
                        if(grid[i + 1][j] == 1)
                            overlapping++;
                    }else{
                        if(grid[i][j + 1] == 1)
                            overlapping++;
                        if(grid[i + 1][j] == 1)
                            overlapping++;
                    }
                }
            }
        }
        return ((4 * landCell )- (2 * overlapping));
    }
}