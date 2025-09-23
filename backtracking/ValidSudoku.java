https://leetcode.com/problems/valid-sudoku/description/

class Solution {
  
    public boolean isValidSudoku(char[][] board) {
        
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char num = board[row][col];
                if( num != '.'){
                    // temporarily remove number
                    board[row][col] = '.';
                    if(!isSafe(board, row, col, num)){
                        return false;
                    }
                    board[row][col] = num;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char num){

        // check for each row 
        for ( int i = 0; i < 9; i++ ){
            if(board[row][i] == num){
                return false;
            }
        }

        // check for each col
        for (char[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        // check for 3*3 subgrid
        int sqrt = 3;
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++){
            for (int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
