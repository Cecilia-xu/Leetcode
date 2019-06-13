# Intuition
This question is similar to the question named Single Number. However, we notice that the array is sorted and the time complexity of the solution should be O(logn).
Therefore, we decide to use binary search to solve this problem.
# Algorithm
When we use mid = left + (right - left) / 2 to solve this problem, we should figure out how to change “left” and “right”。And we founf several facts:
- If mid is even and it is equal to the last number, this single element cannot exist in the range [0,mid]. Then, we update left = mid + 1. Otherwise, we update right = mid
- If mid is odd and it is equal to the next number, this single element cannot exist in the range [0,mid]. Then, we update left = mid + 1. Otherwise, we update right = mid
- The easiest way to find the last/next number mentioned above is using XOR.
# Pseudocode
```Java
Input: int[] nums
Output: int (这个数的值/不是index)

int left = 0, right = nums.length
while (left < right) :
  int mid = left + (right - left) / 2
  int n = mid ^ 1
  if (mid < nums.length && n < nums.length && nums[mid] == nums[n]) then left = mid + 1 else right = mid
return nums[left]
```
# Complexity
- Time complexity: O(logn)
- Space complexity: O(1)
