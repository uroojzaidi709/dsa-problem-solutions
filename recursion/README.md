# 1342. Number of Steps to Reduce a Number to Zero

## Problem Overview:

This problem requires us to find the number of steps to reduce a non-negative integer num to zero. The allowed operations are: dividing by 2 if the number is even, and subtracting 1 if the number is odd.

## Solution Approach (Recursion):

The provided solution uses a **recursive** approach to solve the problem. A **helper function helper(num, steps)** is used to track the number and the steps taken.

### Base Case: The recursion terminates when num is equal to 0. At this point, the accumulated steps are returned, providing the final count.

### Recursive Step: 

For any non-zero num, the function checks its parity:

If num is even (num % 2 == 0), it makes a recursive call with num / 2 and increments the steps count.

If num is odd, it makes a recursive call with num - 1 and increments the steps count.

This process models the problem's rules by systematically reducing the number until it reaches zero, with each recursive call representing one step.

## Complexity:

### Time Complexity: O(log n)

The number of steps is proportional to the logarithm of the input number because the primary operation (dividing by 2) halves the number, which is a characteristic of logarithmic time complexity.

### Space Complexity: O(log n)

The space complexity is determined by the depth of the recursion stack. Since the number of recursive calls is logarithmic with respect to the input number, the space required for the call stack is also logarithmic.
