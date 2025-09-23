# 51. N-Queens

## Problem Overview:

The N-Queens puzzle involves placing n queens on an nxn chessboard such that no two queens can attack each other. This means no two queens can share the same row, column, or diagonal. The goal is to find all distinct valid board configurations.

## Solution Approach (Backtracking):

This problem is a classic example of **backtracking**. The core idea is to explore all possible placements of queens one row at a time. If a placement is safe, we proceed to the next row. If it's not, we "backtrack" to the previous row and try a different column for the last placed queen.

The algorithm uses a **recursive function, queens(board, row, ans)**, that attempts to place a queen in the given row:

### Base Case: 
If all queens have been successfully placed (i.e., row equals n), a valid solution has been found. We convert the boolean board into the required string format and add it to our list of answers.

### Recursive Step: 
For the current row, we iterate through each column (col). For each (row, col) position, we check if it's safe to place a queen there using the isSafe() helper function.

### Safety Check (isSafe): 
The isSafe() function verifies three conditions to ensure no other queen can attack the current position:

### Vertical Check: 
It looks for any queens in the same column in previous rows.

### Diagonal Up-Left Check: 
It checks the upper-left diagonal.

### Diagonal Up-Right Check: 
It checks the upper-right diagonal.

### Placement and Backtracking:
If a position is safe, we place a queen **(board[row][col] = true)** and make a recursive call for the next row (row + 1). After the recursive call returns (either because a solution was found or a dead end was reached), we backtrack by removing the queen **(board[row][col] = false)**. This allows the loop to try the next column in the current row.

This process systematically explores all possible valid configurations, ensuring all distinct solutions are found.

## Complexity:

### Time Complexity: O(n!)
The time complexity is roughly O(n!) because in the worst-case scenario, the algorithm explores all permutations of placing n queens on an nxn board.

### Space Complexity: O(n²)
The space complexity is determined by the size of the board (n*n) and the recursion depth, which is n.
