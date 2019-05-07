# My solution
```Java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int low = 0;
        int high = nums.length -1;
        //Binary search for the target number
        while (low <= high) {
            int medium = low + (high - low) / 2;
            //If target number is found, use traversal method to search the most left index and the most right index 
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
            //If target number cannot be found, keep searching
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
<strong>HOWEVER, TIME COMPLEXITY IS o(n) !!!(WORST CASE)</strong><br>
space complexity: O(1)
# Solution 1: linear search
```Java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        //find the start index of the the range
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        if (result[0] == -1) {
            return result;
        }
        // find the end index of the range
        for (int j = nums.length - 1; j >= 0; j --) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
        }
        return result;
    }
}
```
