# My solution：Bit manipulation
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
# Official solution: Bit manipulation
```Java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
```
注意：0对某一个数做XOR计算，最终结果依然是这个数
