# *Algorithm: Silding window techinique
Use two different pointers as a "sliding window". The left pointer is faster than the right one.
1. If the sum of the numbers in the sliding window is smaller than s, move the right pointer and get a new sum.
2. Or, if the sum of the numbers in the sliding window is larger than s, move the left pointer and get a new sum.
3. Compare the new sum we got with s, decide whether or not update the minimum size of subarray.
# Pseudocode
```
Input: int[] nums, int s
Output: int res

// Intialize two pointers (sliding window does not contain any element)
left <- 0
right <- -1
// Intialize sum (No element. Sum = 0)
sum <- 0
// Intialize the size (A size that can be used to find minimize)
res <- nums.length + 1/ INT_MAX 

// Make the left pointer of the sliding window traverse the array
while (left < nums.length):
  // Update sliding window
  if (sum < s && right + 1 < nums.length) then sum += nums[++right]
  else sum -= nums[left--]
  
  // Update result
  if (sum >= s) then res = min (res, right - left + 1)
  
// Make sure the res isthe minimum size of subarray
if (res == nums.length + 1 / INT_MAX) then return 0

return res
  
```
# Complexity
- Time complexity:
- Space complexity:
