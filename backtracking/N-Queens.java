https://leetcode.com/problems/n-queens/description/

class Solution {
  
    public List<List<String>> solveNQueens(int n) {
         
         List<List<String>> ans = new ArrayList<>();
         boolean[][] board = new boolean[n][n];
         queens(board, 0, ans);
         return ans;
     }

     static void queens(boolean[][] board, int row, List<List<String>> ans ){

        // base condition
        if(row == board.length){

            ans.add(display(board));
            return;
        }

        for ( int col = 0; col < board.length; col++){

            if(isSafe(board,row,col)){

                 board[row][col] = true;
                 queens(board, row + 1, ans);
                 board[row][col] = false;

            }
        }
     }

     static boolean isSafe(boolean[][] board, int row, int col){

        // check for vertical row
        for (int i = 0; i < row; i++){
            if(board[i][col]){
               return false;
            }
        }

        int maxLeft = Math.min(row, col);
        for ( int i = 1; i <= maxLeft; i++){
            if(board[row-i][col - i]){
                return false;
            }
        }

        int maxRight = Math.min(row, board.length - col - 1);
        for ( int i = 1; i <= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
     }

     static List<String> display(boolean[][] board){
          
          List<String> ans = new ArrayList<String>();

          for (boolean[] row : board){
              
              StringBuilder sb = new StringBuilder();

              for(boolean element : row){
                  
                  if(element){
                    sb.append("Q");
                  }else{
                    sb.append(".");
                  }
              }

              ans.add(sb.toString());
          }
          return ans;
     }
}
