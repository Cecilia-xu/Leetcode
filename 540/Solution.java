// Solution: binary search
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid = mid - 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }
            else {
                right = mid;
            }
        }
        
        if (left % 2 == 1) {
            return nums[left];
        }
        else {
            return nums[right];
        }
    }
}
