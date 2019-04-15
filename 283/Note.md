# Pseudocode
## Solution 1 (Brute Force)
- Tips: Use another array to store the non-zero elements.
-
```
Input: int[] nums
Output: void

//create an array list to store all the non-zero numbers
ArrayList<Integer> nonZeroNums 

//search all the non-zero numbers and store them in the arrayList
for int i -> 0 to nums.length-1:
if ( nums[i] != 0 ) then nonZeroNums.add(nums[i])

// transfer the original array to an array in a required order
int j = 0
for j -> 0 to nonZeroNums.size-1:
nums[i] = nonZeroNums.get(i)
for j - > nonZeroNums.size-1 to nums.length-1
nums[j] = 0

## Solution 2 (Two pointers)
