# My solution
This solutin is the same as the first offical solution.
## Algorithm (Two pointers)
1. 1st pointer: record the index of the next value which is not equal to val. If we find any element which is not equal to val, assign this number to this position.
2. 2st pointer: traverse the array
## Pseudocode
```
Input: int[] nums[], int val
Output: int i

int i = 0
for j -> 0 to nums.length - 1 :
  if (nums[j] != val) then nums[i] = nums[j] and i++
  
return i

```
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
# Solution 2
