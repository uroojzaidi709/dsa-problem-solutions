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


# 52. N-Queens II

## Problem Overview:

This problem is a variation of the N-Queens puzzle. Instead of returning all distinct board configurations, the goal is to return only the total number of distinct solutions. The rules for placing queens remain the same: no two queens can share the same row, column, or diagonal.

## Solution Approach (Backtracking):

The solution uses the same backtracking core as the N-Queens problem. The main difference lies in how the base case is handled and how results are aggregated.

### Recursive Function (countQueens): 
A recursive function is used to explore all possible placements. Instead of building a list of board configurations, it returns an integer count.

### Base Case: 
When a queen has been successfully placed in the final row (row == board.length), it signifies a complete and valid solution. Instead of adding a board to a list, the function returns 1, which represents a single, valid solution found.

### Recursive Step & Aggregation: 
The function iterates through each column in the current row. If a position is safe, it places a queen, recursively calls itself for the next row, and adds the returned count to a running total. After the recursive call, it backtracks by removing the queen to explore other possibilities.

### Final Count: 
The initial call to the recursive function returns the sum of all valid solutions found, providing the final answer.

This approach is highly efficient for counting solutions, as it avoids the overhead of generating and storing the board configurations for each valid solution.

## Complexity:

### Time Complexity: O(n!)
Similar to the original N-Queens problem, the algorithm explores all permutations of placing n queens.

### Space Complexity: O(n²)
The space is primarily used for the recursion stack and the boolean board.
