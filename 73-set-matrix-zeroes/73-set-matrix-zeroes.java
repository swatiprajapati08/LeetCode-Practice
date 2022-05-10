class Solution {
    public void setZeroes(int[][] matrix) {
        
        // HashSet<Integer> hs = new HashSet<>();
        ArrayList<List<Integer>> arr = new ArrayList<>();
        
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    arr.add(temp);
                   // break;
                }
            }
        }
        
        
        for(List<Integer> p: arr){
            makeRowCol(matrix,p.get(0),p.get(1));
        }
    }
        void makeRowCol(int[][] matrix,int r, int c){
            for(int i=0;i<matrix.length;i++)
                matrix[i][c] = 0;
            for(int j = 0; j<matrix[0].length;j++)
                matrix[r][j] = 0;
    }
}