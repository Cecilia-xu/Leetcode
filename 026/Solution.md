# Solution
> Time complexity: O(n) <br> Space complexity: O(1)
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
注意：只要是数组类问题都要优先考虑数组为空的情况，形成条件反射
