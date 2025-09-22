# dsa-problem-solutions
My solutions to Data Structures and Algorithms problems in Java (and C++ later), organized by topic.

744. Find Smallest Letter Greater Than Target

Problem Overview:
This problem requires finding the smallest character in a sorted array that is lexicographically greater than a given target character. A key constraint is that the array is sorted, which allows for a highly efficient search. If no such character is found, the problem requires a "wrap-around" behavior, returning the first element of the array.

Solution Approach:
The optimal approach leverages the sorted nature of the input array by using Binary Search. This algorithm repeatedly divides the search interval in half. It compares the target character with the middle element of the array.

If the target is less than the middle character, the solution must lie in the left half, so we narrow our search to that portion.

If the target is greater than or equal to the middle character, we discard the left half and continue searching in the right half.

This process continues until the search space is narrowed down to a single element, which will be the smallest character greater than the target. The modulo operator (%) elegantly handles the edge case where no greater character exists, ensuring the first element is returned as required.

Complexity:
Time Complexity: O(logn)

Binary search reduces the search space by half in each step, making it extremely efficient for large inputs.

Space Complexity: O(1)

The solution uses a constant amount of extra space, regardless of the input size, as it only requires a few pointers to perform the search.
