# Solution
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        //Important！ Edge case!
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j ++) {
            if (nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        //return length, so we should add 1 on i
        return i + 1;
    }
}
```
