```Java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int medium = low + (high - low) / 2;
            if (target < nums[medium]) {
                high = medium - 1;
            }
            else if (target == nums[medium]) {
                return medium;
            }
            else if (target > nums[medium]) {
                low = medium + 1;
            }
        }
        return -1;
    }
}
```
