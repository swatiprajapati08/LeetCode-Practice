class Solution {
     List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        Ways(0,board);
        return ans;
    }
    
    void Ways(int r,char[][] board){
        if(r == board.length){
            // queen are placed
            List<String> temp = new ArrayList<String>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<board.length;j++){
                    if(board[i][j] == 'Q')
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }
        
        //place each queen in row and explore ways for column
        for(int j = 0; j<board.length;j++){
            if(board[r][j] == '.' && canPlace(r,j,board)){
                board[r][j] = 'Q';
                Ways(r + 1,board);
                //backtrack
                board[r][j] = '.';
            }
        }
    }
    
    boolean canPlace(int r, int c,char[][] board){
        // check back row
        for(int i = r; i>=0;i--){
            if(board[i][c] == 'Q')
                return false;
        }
        // check back left digonal
        for(int i = r,j = c; i >=0  &&j >= 0; i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        
        //check back right diagonal
         for(int i = r,j = c; i >=0  &&j < board.length; i--,j++){
            if(board[i][j] == 'Q')
                return false;
        }
    return true;
    }
}