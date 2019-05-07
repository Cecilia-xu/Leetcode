# Solution:
## 1. range \[low, high\]
```Java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int medium = low + (high - low) / 2;
            if (target == nums[medium]) {
                return medium;
            }
            else {
                if (target < nums[medium]) {
                    high = medium - 1;
                }

                else {
                    low = medium + 1;
                }
            }
        }
        return -1;
    }
}
```
## 2. range \[low, high)
```Java
classs Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        // low == high, [low, high) invalid
        while (low < high) { 
            int medium = low + (high - low) / 2;
            if (target == nums[medium) {
                return medium;
            }
            else {
                // target在[l...mid)中; [mid...r)一定没有target
                if (target < nums [medium]) {
                    high = medium;
                }
                // target在[mid+1...r)中; [l...mid]一定没有target
                else {
                    low = medium + 1;
                }
            }
        }
        return -1;
    }
}
```
