# My solution: combination
## Algorithm
1. find any element which is equal to the target using binary search
2. search the left most index: search leftward from the index we found in the first step by using linear search
3. search the right most index: search rightward from the index we found in the first step by using linear search
## Complexity
- Time complexity: O(n) (WORST CASE)
- Space complexity: O(1)

# Soultion 1: linear search
## Algorithm
1. start from the smallest index and search for the first index whose value equals target
2. start from the largest index and search for the first index whose value equals target
Note：对撞指针（常用）
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
## Pseudocode
```
Input: int[] nums, int target
Output: int[2] result(start/end)

result[] = {-1,-1}
//find the left most 
for i -> 0 to nums.length-1:
    if nums[i] == target then result[0] = i and then break
//check whether needs to find the right most(not neccessary, but can improve efficiency)
if result[0] == -1 then return result
//fint the right most
for i ->nums.length-1 to 0:
    if nums[i] == target then result[1] = i and then break
return result
```
# Solution 2: binary search
## Algorithm
1. Use binary search to find the left most index of the range
2. Use binary search to find the first index whose value is larger than target(the right most index = this index - 1)
## Complexity
Time complexity: O(logn)
Space complexity: O(1)
## Pseudocode
