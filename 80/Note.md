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
  //update the length: when the index is smaller than 2 and this number is larger than the number before last number(length：i -> index of last number: i - 1 -> index of the number before last number: i - 2 )
  if (i < 2 || n > nums[i - 2]) then i ++
return i
```

# Complexity
- Time complexity: O(n)
- Space complexity: O(1)
