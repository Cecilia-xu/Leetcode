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
// Solution 3: find minimum && last unduplicate number + binary search
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left != right && nums[left] == nums[right]) {
            right--;
        }
        int minIdx = findMin(nums, left, right);
        if (target >= nums[minIdx] && target <= nums[right]){
            return binarySearch(nums, target, minIdx, right);
        }
        else {
            return binarySearch(nums, target, left, minIdx - 1);
        }
    }
    
    public int findMin(int[] nums, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]) == nums[left] ? left : right;
    }
    
    public boolean binarySearch(int[] nums, int target, int left, int right) {
         while (left <= right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] == target) {
                 return true;
             } 
             else if (nums[mid] > target) {
                 right = mid - 1;
             }
             else {
                 left = mid + 1;
             }
         }
        return false;
    }
}
