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
！ 这个解法真的是简洁又优美
