// Solution 1: divide and conquer
class Solution {
    public int findMin(int[] nums) {
        return findLocalMin(nums, 0, nums.length - 1);
    }
    
    public int findLocalMin(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        // base case 2*: since we have duplicate, we can only ensure nums[left] is the smallesr when the searching area is sorted
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.min(findLocalMin(nums, left, mid), 
                        findLocalMin(nums, mid + 1, right));
    }
}
// Solution 2: binary search
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left != right && nums[left] == nums[right]) {
            left ++;
        }
        if (left == nums.length - 1) {
            return nums[left];
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return nums[left] <= nums[right] ? nums[left] : nums[right];
    }
}
