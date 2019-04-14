# Pseudocode
```
Input: int[] nums
Output: int 

int length = nums.length;
//Null array
if (length == 0) return 0;
// Initailize i to 0, i represents the index of the last number in the set which is removed duplicates
int i = 0;
// Intiailize j to 1, j represents the index of the first number in the set which needs to be searched
for (int j = 1 to nums.length)
  if (nums[i] != nums [j]) then i++,nums[i]=nums[j] 
}
```
# Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)
