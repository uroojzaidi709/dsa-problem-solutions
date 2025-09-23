# 17. Letter Combinations of a Phone Number

## Problem Overview:
Given a string of digits from 2-9, the task is to generate all possible letter combinations that can be represented by the digits, based on a standard phone keypad mapping.

## Solution Approach (Recursion):
This problem is a classic example of recursion and can be solved using a divide-and-conquer approach. The core idea is to process the input string one digit at a time and recursively generate combinations for the remaining digits.

### Helper Function: 
A recursive helper function, helper(processed, unprocessed), is used.

### processed: 
The combination of letters built so far.

### unprocessed:
The remaining digits to be processed.

### Base Case:
The recursion stops when unprocessed is empty. This means a complete combination has been formed. The processed string is added to the result list.

### Recursive Step: 
In each call, the function takes the first digit from unprocessed, gets its corresponding letters from the KEYPAD mapping, and iterates through each letter. For each letter, it makes a recursive call with the letter appended to processed and the rest of the digits (unprocessed.substring(1)) passed as the new unprocessed string.

### Combining Results: 
The addAll method is used to merge the lists of combinations returned from each recursive call, building the final result.

This approach effectively explores all possible combinations by branching at each digit, creating a tree-like structure of all potential outcomes.

## Complexity:

### Time Complexity: O(4^N * N)
where N is the length of the input string.

The term 4^N arises from the worst-case scenario where each digit maps to 4 letters (e.g., '7' or '9'). For each of the N digits, we have at most 4 choices.

The term N comes from the time it takes to create new strings by concatenating the characters (e.g., processed + ch).

### Space Complexity: O(N)

The space complexity is determined by the maximum depth of the recursion tree, which is N. This space is used for the call stack. The space for the output list is not counted as auxiliary space.


# 78. Subsets

## Problem Overview:
The task is to find all possible subsets (the power set) of a given integer array containing unique elements.

## Solution Approach (Iterative):
The provided solution uses an iterative approach to build the power set incrementally. The key idea is that for each number in the input array, we can generate a new set of subsets by adding this number to all the subsets we've already found.

### Initialization: 
The process starts with a single subset: an empty list []. This is the foundational subset.

### Iterative Expansion: 
The algorithm iterates through each number in the input array nums. For each number:

It gets the current size of the outer list (which contains all the subsets found so far).

It then loops through all existing subsets in the outer list.

For each existing subset, it creates a new subset by copying the existing one and adding the current number to it.

This new subset is then added to the outer list.

### Final Result: 
After iterating through all numbers in nums, the outer list will contain all possible subsets.

This method systematically builds the power set, doubling the number of subsets with each new element considered.

## Complexity:

### Time Complexity: O(2^N * N)

The term 2^N comes from the total number of subsets in the power set.

The term N comes from the time it takes to copy the elements of a subset in the inner loop.

### Space Complexity: O(2^N * N)

The space required is proportional to the size of the output list, which is the total number of subsets multiplied by the average size of a subset.
