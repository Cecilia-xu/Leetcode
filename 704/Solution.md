# Solution 1： range \[low, high\]
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
# Solution 2 : range \[low, high)
```Java
classs Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int medium = low + (high - low) / 2;
            if (target == nums[medium) {
                return medium;
            }
            else {
                if (target < nums [medium]) {
                    high = medium;
                }
                else {
                    low = medium - 1;
                }
            }
        }
        return -1;
    }
}
```
