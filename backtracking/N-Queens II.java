https://leetcode.com/problems/n-queens-ii/description/

class Solution {

    public int totalNQueens(int n) {
         boolean[][] board = new boolean[n][n];
         return countQueens(board, 0);
    }

    static int countQueens(boolean[][] board, int row){

        if( row == board.length){
            return 1;   // returns one valid solution
        }

        int count = 0;

        for(int col = 0; col < board.length; col++){

            if(isSafe(board, row, col)){

                board[row][col] = true;
                count += countQueens(board,row + 1);
                board[row][col] = false; // backtrack
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){

        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row,col);
        for(int i = 0; i <= maxLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }
 
         int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 0; i <= maxRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }

        return true;
    }
}
