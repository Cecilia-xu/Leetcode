# Solution 1: Linear search
``` Java
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
```
Note:对于peak的理解，对于默认return值的理解
# Solution 2: Binary search
``` Java
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        
        if (nums[right] > nums[left]) {
            return right;
        }
        else {
            return left;
        }
    }
}
```
