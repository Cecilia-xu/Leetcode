// Solution 1: template 2
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        else {
            return nums[right];
        }
    }
}
// Solution 2: template 1
class Solution {
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
        
        return left < 0 ? nums[0] : nums[left];
    }
}
