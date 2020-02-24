// Solution 1: linear search
class Solution {
    public boolean search(int[] nums, int target) {
        for (int n : nums) {
            if (n == target) {
                return true;
            }
        }
        return false;
    }
}
// Solution 2: binary search
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left != right && nums[left] == nums[right]) {
            left++;
        }
        if (left == nums.length - 1) {
            return nums[left] == target;
        }
        int start = nums[left], end = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] >= start) {
                if (target >= start && nums[mid] > target) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
            else {
                if (target <= end && nums[mid] < target) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] == target) {
            return true;
        }
        else if (nums[right] == target) {
            return true;
        }
        else {
            return false;
        }
    }
}
