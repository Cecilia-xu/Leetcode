# Algorithm
Notice that the array is sorted and the starting index is 1 not 0
- Iterate the array from two ends to the middle
- Sum these two element
- If it is larger than the target, move the pointer at the end
- If it is smaller than the target, move the pointer at the start
- Stop iterating when sum is equal to target or start is not smaller than end 
# Pseudocode
Input: int[] nums
Output； int[2] result

```
int start = 0
int end = nums.length - 1
int[] result = {-1,-1}
while (nums[start] + nums[end] != target && start < end):
  if (nums[start} + nums[end] < target) then start ++
  else if (nums[start] + nums[end] > target) then end --
if (nums[start] + nums[end] == target) then result[0] = start + 1 , result [1] = end + 1

return result 
```
# Complexity
- Time complexity: O(n)
- Space complexity: O(1)
