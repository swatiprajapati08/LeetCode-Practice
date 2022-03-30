class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j = matrix[0].length - 1, i = 0;
        while(i < matrix.length && j>=0){
            if(target == matrix[i][j])
                return true;
            else if(target > matrix[i][j])
                i++;
            else
                j--;
        }
        return false;
    }
}