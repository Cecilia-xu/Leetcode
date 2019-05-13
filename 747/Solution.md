# My solution
```Java
class Solution {
    public int dominantIndex(int[] nums) {
        int largestNum = 0;
        int largestIndex = 0;
        int val = 0;
        for (int i = 0; i < nums.length;  ++ i) {
            if (nums[i] > largestNum) {
                largestNum = nums[i];
                largestIndex = i;
            }
        }
        for (int j = 0; j < nums.length; ++ j) {
            if (nums[j] > val && nums[j] != largestNum) {
                val = nums[j];
            }
        }
        if (largestNum >=  2 * val) {
            return largestIndex;
        }
        return -1;
    }
}
```
