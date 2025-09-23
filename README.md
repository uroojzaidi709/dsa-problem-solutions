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


268. Missing Number

Problem Overview:
The task is to find a single missing number from an array of n distinct numbers. The numbers are guaranteed to be in the range [0,n]. The array's length is also n.

Solution Approach:
The most optimal solution utilizes the Cyclic Sort algorithm. This technique is ideal for problems involving arrays with a limited range of numbers. The core idea is to place each element at its correct sorted position. For this problem, a number k should ideally be at index k.

The algorithm proceeds in two main steps:

Placement: We iterate through the array. For each number nums[i], we check if it is at its correct index. If nums[i] is less than the array length and is not in its correct position (nums[i] != nums[nums[i]]), we swap it with the element at its correct index. This process continues until all numbers are in their correct positions. The number n (if present) will remain at an incorrect index because its correct index is outside the array's bounds.

Identification: After the first step, we iterate through the array one more time. The first index i where nums[i] is not equal to i is the missing number. This is because every other number has been placed in its correct spot. If all numbers from 0 to n−1 are in their correct places, the missing number must be n.

Complexity:
Time Complexity: O(n)

The cyclic sort part of the algorithm makes at most n swaps in the worst-case scenario. Each number is visited and swapped into its correct place at most once, and the final search is a single pass, resulting in a linear time complexity.

Space Complexity: O(1)

The solution is performed in-place on the input array and does not require any additional data structures, thus using constant extra space.


448. Find All Numbers Disappeared in an Array
     
Problem Overview:
This problem asks us to identify all numbers that are missing from an array of n integers. The numbers are guaranteed to be within the range [1,n]. Unlike some similar problems, this one allows for duplicate numbers in the input.

Solution Approach:
The solution uses the Cyclic Sort pattern, an efficient technique for sorting arrays containing numbers within a specific range. The central idea is to place each number at its correct, corresponding index. Since the numbers are in the range [1,n], the number x should ideally be located at index x−1.

The algorithm works in two passes:

Placement Pass: We iterate through the array. For each element nums[i], we determine its correct index, which is nums[i] - 1. If the element is not already at its correct position, we swap it with the element that should be at that position. This process continues until all numbers are cyclically sorted into their respective indices.

Identification Pass: Once the array is sorted, we perform a second pass. We check each index i. If nums[i] is not equal to i + 1, it means the number i + 1 is missing from the array. We add i + 1 to our result list.

Complexity:
Time Complexity: O(n)

The cyclic sort algorithm ensures each number is placed correctly with at most a single swap, making the first pass a linear time operation. The second pass to find the missing numbers also takes linear time.

Space Complexity: O(1)

The solution is performed in-place without using any auxiliary data structures proportional to the input size. We do not count the returned list as extra space, as specified by the problem's follow-up.


645. Set Mismatch
     
Problem Overview:
This problem asks us to find two numbers from an array that was originally a set of integers from 1 to n. Due to an error, one number was duplicated, and another was lost. We need to identify the number that appears twice and the number that is missing. The array nums represents the data after this error.

Solution Approach:
The solution uses the Cyclic Sort pattern, an efficient technique for sorting arrays containing numbers within a specific range. The central idea is to place each number at its correct, corresponding index. Since the numbers are in the range [1, n], the number x should ideally be located at index x-1.

The algorithm works in two passes:

Placement Pass: We iterate through the array using a while loop. For each element nums[i], we determine its correct index, which is nums[i] - 1. If nums[i] is not at its correct position (i.e., nums[i] != nums[nums[i] - 1]), we swap it with the element that should be at that position. This process continues until nums[i] is at its correct position.

Identification Pass: After the placement pass, the array is almost sorted. We then perform a second pass using a for loop. We check each index index. If nums[index] is not equal to index + 1, it means a mismatch has been found. The value nums[index] is the number that appears twice, and index + 1 is the number that is missing. We then return these two values.

This in-place modification allows us to solve the problem without using any extra data structures.

Complexity:

Time Complexity: O(n)
The cyclic sort algorithm ensures that each number is placed correctly. Although there's a while loop inside the main while loop, each element is swapped at most once to its correct position. The second pass is a simple linear scan. This results in a total time complexity that is linear with respect to the number of elements.

Space Complexity: O(1)
The solution is performed in-place and does not use any auxiliary data structures that scale with the input size. Therefore, the space complexity is constant.
