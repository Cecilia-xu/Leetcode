# My solution 1：Bit manipulation
> Time complexity: O(n) <br> Space complexity: O(1)
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
# Solution 2: Hash set
> Time complexity: O(n) <br> Space complexity:O(n)
```Java
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.isEmpty() && set.contains(n)) {
                set.remove(n);
            }
            else {
                set.add(n);
            }
        }
        return set.iterator().next();
    }
}
```
Note: get the first element from a set: using set.iterator().next()
