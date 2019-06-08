# Solution 1: counting sort
## Algorithms
Since the color can be represented by 0, 1, 2(just 3 numbers), we can create an array, in whcih the index can represent the color and the value can represnt the number of each color.
## Pseudocode
``` Java
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
int index = 0
for int i -> 0 to
```
## Complexity
- Time complexity: O(n)
- Space complexity: O(k),k是element的取值范围!因为创建的数组大小和有几个元素相关
# Solution 2: quick sort 3 ways
## Algorithms
Use three different pinters:
1. mark the last index of zero
2. mark the index of traversal
3. mark the first index of two
## Pseudocode
``` Java
Input: int[] nums
Output: void 

//Intiailize two indexes, make sure all 0s are in the range of  [0, zero] and all 2s are in the range of [two, nums.length - 1] 
int zero = -1
int two = nums.length

// Intialize the result
int result = 0

// i is the pointer which can be used to traverse the array.
//!! We just need to traverse the array from 0 to two because [two, nums.length - 1] are sorted well. 
for (int i = 0; i < two; ) :
  if (nums[i] == 1): i ++
  else if (nums[i] == 0) : swap(nums,i ++, -- two)
  else : assert (nums[i] == 2)  swap (nums, i ++, ++ zero)
```
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
