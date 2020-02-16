class Solution {
    public int findMin(int[] nums) {
        return findLocalMin(nums, 0, nums.length - 1);
    }
    
    public int findLocalMin(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.min(findLocalMin(nums, left, mid), 
                        findLocalMin(nums, mid + 1, right));
    }
}
