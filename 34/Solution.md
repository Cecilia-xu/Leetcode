# My solution
``Java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int medium = low + (high - low) / 2;
            if (nums[medium] == target) {
                for (int i = medium;  i >= 0 ; i --) {
                    if (nums[i] == target) {
                        result[0] = i;
                    }
                }
                for (int j = medium; j < nums.length; j ++) {
                    if (nums[j] == target) {
                        result[1] = j;
                    }
                }
                return result;
            }
            else {
                if (nums[medium] < target) {
                    low = medium + 1;
                }
                if (nums[medium] > target) {
                    high = medium -1;
                }
            }
        }
        return result;
    }
}
```
