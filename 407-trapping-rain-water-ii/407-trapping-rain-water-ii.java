class Solution {
    public static class Pair implements Comparable<Pair>{
        int row,col,val;
        public Pair(int row,int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        public int compareTo(Pair other){
            return this.val - other.val;
        }
        
    }
    public int trapRainWater(int[][] mat) {
        
        int water = 0;
        int rowL = mat.length;
        int colL = mat[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        int row[] = {1,-1,0,0};
        int col[] = {0,0,1,-1};
        
        
        
        //pushing the boundary building so that overflow doesnt occur
        for(int i = 0;i<rowL;i++){
            if(mat[i][0] != -1){
                q.add(new Pair(i,0,mat[i][0]));
                mat[i][0] = -1;
            }
            if(mat[i][colL - 1] != -1){
                q.add(new Pair(i,colL - 1,mat[i][colL - 1]));
                mat[i][colL - 1] = -1;
            }
        }
        for(int j = 0;j < colL;j++){
            if(mat[0][j] != -1){
                q.add(new Pair(0,j,mat[0][j]));
                mat[0][j] = -1;
            }
            if(mat[rowL - 1][j] != -1){
                q.add(new Pair(rowL - 1,j,mat[rowL - 1][j]));
                 mat[rowL - 1][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            Pair min = q.remove();
            
            //check all its 4 directions
            for(int i = 0; i < 4;i++){
                int r = min.row + row[i];
                int c = min.col + col[i];
                
                //check valid r and c and they are not visited
                
                if(r >= 0 && r < rowL && c >= 0 && c < colL && mat[r][c] != -1){
                    
                    //check if it can store water
                    if(min.val > mat[r][c]){
                        water += (min.val - mat[r][c]);
                        q.add(new Pair(r ,c , min.val)); //boundary will be larger one  3, 1, 0 ,100  so now boundry in that case will be 3 not 1 for zer0.
                    }
                    else{
                        //cant store any water
                        q.add(new Pair(r, c, mat[r][c]));
                    }
                    
                    //mark as visited
                    mat[r][c] = -1;
                }
            }
        }
        return water;
    }
}