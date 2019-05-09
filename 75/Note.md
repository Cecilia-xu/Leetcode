# Solution 1: counting sort
## Algorithms
Since the color can be represented by 0, 1, 2, we can create an array, in whcih the index can represent the color and the value can represnt the number of each color.
## Pseudocode
```
Input: int nums[]
Output: void

// create an array to store the number of each color
int[] count = {0,0,0}
//traverse the array and count the number of each color
for int i -> 0 to nums.length - 1 :
  if (nums[i] == 0) then count[0]++
  else if (nums[i] == 1) then count[1]++
  else if (nums[i] == 2) then count[2]++
  //Note: avoid the invaild input
  else assert ("Invaild color")
//construct the new array 
for int j-> 0 to count[0] - 1:
  nums[j] = 0
for int j-> count[0]  to count[0] - 1 + count[1]:
  nums[j] = 1
for int j -> count[0] + count[1] to nums.length - 1:
  nums[j] = 2
```
## Complexity
- Time complexity: O(n)
- Space complexity: O(k),k是element的取值范围
