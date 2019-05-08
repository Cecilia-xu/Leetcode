# Solution
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i ++] = n;
            }
        }
        return i;
    }
}
```
Note:
1. traverse the array-for (int n : nums)
2. Clear, beautiful (especially in the logic statement)
