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
### 写法 2
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
            if (j < 2 || nums[j] > nums[i - 2]) {
                nums[i] = nums[j];
                i ++;
            } 
        }
        return i;
    }
}
```
