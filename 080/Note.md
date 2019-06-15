# Intution
Focus on the statement of the question: sorted array!
# Algorithms: Two pointers
1. 1st pointer: focus on traverse the array
2. 2nd pointer：focus on finding the numbers that meet the requirement of the question
# Pseudocode
```
Input: int[] nums
Output: int i

//initialize the result length
int i = 0;

// traverse the array
for (int n: nums)
  //update the length: when the index is smaller than 2 and 
  //this number is larger than nums[i-2]
  //这里必须是和nums[i-2]比较，因为pinter i是已经整理好顺序的部分
  //我们关注的是和已去重数组的2个之前的数比较，而不是当前数组位置两个之前的比较
  if (i < 2 || n > nums[i - 2]) then i ++
return i
```

# Complexity
- Time complexity: O(n)
- Space complexity: O(1)
