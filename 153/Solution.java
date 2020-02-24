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
// Solution 3: divide and conquer
class Solution {
    public int findMin(int[] nums) {
        return findLocalMin(nums, 0, nums.length - 1);
    }
    
    public int findLocalMin(int[] nums, int left, int right) {
        // base case 1: when the searching size is reduced to 1/2, return the smaller one
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        // base case 2: when the whole searching space is sorted, return the smallest one
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        // recursion rule: find the smaller one in two smaller searching space
        int mid = left + (right - left) / 2;
        return Math.min(findLocalMin(nums, left, mid), 
                        findLocalMin(nums, mid + 1, right));
    }
}
