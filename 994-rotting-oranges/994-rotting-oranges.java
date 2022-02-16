class Solution {
    int row[] = {0, 0, 1, -1};
    int col[] = {1, -1, 0, 0};
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 1 && cols == 1) {
            return grid[0][0] == 1 ? -1 : 0;
        }
        Queue<Integer> q = new ArrayDeque<>();
        int freshOranges = 0, time = 0;
        for(int i=0;i<rows;i++){
            for(int j = 0; j< cols;j++){
                if(grid[i][j] == 2)
                    q.offer(i * cols + j);
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }
        
        while(freshOranges != 0 && q.size() > 0){
            time++;
            int level = q.size();
            for(int i = 0; i< level && freshOranges != 0;i++){
                int rotten = q.poll();
                int r = rotten / cols;
                int c = rotten % cols;
                
                for(int j = 0; j < 4;j++){
                    int x = r + row[j];
                    int y = c + col[j];
                    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    freshOranges--;
                    
                    if(freshOranges == 0)
                        break;
                    q.offer(x * cols + y);
                }
            } 
        }
        return freshOranges == 0 ? time : -1;
    }
}