# Solution 1: Linear search
class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] - nums[i + 1] > 0) {
                return i;
            }
        }
        return nums.length - 1;
    } 
}
Note:对于peak的理解，对于默认return值的理解
