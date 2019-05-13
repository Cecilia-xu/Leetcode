# My solution
```Java
class Solution {
    public int dominantIndex(int[] nums) {
        int largestNum = 0;
        int largestIndex = 0;
        int val = 0;
        // find the largest number in the array
        for (int i = 0; i < nums.length;  ++ i) {
            if (nums[i] > largestNum) {
                //record the largest number and largest index(because i will increase at the same time)
                largestNum = nums[i];
                largestIndex = i;
            }
        }
        // find the second largest number in the array
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
