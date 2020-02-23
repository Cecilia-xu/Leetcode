# My solution
```Java
// Solution 1: template 2 version
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        
        if (nums[left] != target && nums[right] != target) {
            return new int[]{-1,-1};
        }
        
        int start = (nums[left] == target ? left : right);
        
        left = start; right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        
        int end = (nums[right] == target ? right : left);
        
        return new int[]{start, end};

    } 
    
}
```
```Java
// Solution 2: template 1 version
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        int left = 0, right = nums.length - 1;
        int start, end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1,-1};
        }
        else {
            start = left;
        }
        
        left = start;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return new int[]{start, right};
    } 
}
```
