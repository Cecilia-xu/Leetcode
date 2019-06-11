# Solution：Bit manipulation
```Java
class Solution {
    public int singleNumber(int[] nums) {
        int c = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            c ^= nums[i];
        }
        return c;
    }
}
 
```
