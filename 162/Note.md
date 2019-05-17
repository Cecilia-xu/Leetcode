# Solution 1: linear search
## Intuition
!. Firstly, comprehend what is "peak"? Distinguish it from the local maxium. If an element in array is larger than the next element, 
we can call it a peak in the array.
2. In other words, an ascending array also has a peak, which is the last element. As well, the descending array has a peak, which is 
the first element in the array.
## Algorithms
Find the index i so that nums[i] > nums[i + 1]. Otherwise, we can conlude this array is an ascending array, the peak is the last element in the array.
## Pseudocode
```
Input: int[] nums
Output: int i

for i <- 0 to nums.length - 2:
  if (nums[i] > nums[i + 1]) return i

return nums.length -1
```
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
