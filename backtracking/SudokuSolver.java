https://leetcode.com/problems/sudoku-solver/description/

class Solution {
  
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }

    private boolean solve(char[][] board){

        // 2 loops for empty cells
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                 if(board[row][col] == '.'){
                    // fill empty cells with numbers
                    for (char number = '1'; number <= '9'; number++){
                        if(isSafe(board, row, col, number)){;
                        board[row][col] = number;
                        if(solve(board)){
                            return true;   // recursively solve rest of the board and if solved return true
                        }else{
                            board[row][col] = '.';  // backtrack
                        }
                    }
                }
                return false;
             }
         }
     }
     return true;
}

 private boolean isSafe(char[][] board, int row, int col, char number){

    // check each row 
    for(int i = 0; i < 9; i++){
        if(board[row][i] == number){
            return false;
        }
    }

    // check each col
    for (char[] nums : board){
        if(nums[col] == number){
            return false;
        }
    }

    // check 3*3 subgrid
    int sqrt = 3;
    int rowStart = row - row % sqrt;
    int colStart = col - col % sqrt;

    for(int r = rowStart; r < rowStart + sqrt; r++){
        for (int c = colStart; c < colStart + sqrt; c++){
            if(board[r][c] == number){
                return false;
            }
        }
    }

    return true;
  }

}
