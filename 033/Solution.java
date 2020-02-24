// Solution 1: find minimum in a rotated array + binary search in a sorted array
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIdx = findMin(nums);
        if (target >= nums[minIdx] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, minIdx, nums.length - 1);
        }
        else {
            return binarySearch(nums, target, 0, minIdx - 1);
        }
    }
    
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left < 0 ? 0 : left;
    }
    
    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
// Solution 2: binary search
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int start = nums[0], end = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
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
            return left;
        }
        else if (nums[right] == target) {
            return right;
        }
        else {
            return -1;
        }
    }
}
