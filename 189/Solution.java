// Reverse for three times --> rotated array (find two parts for reversion: unrotated, rotated) --> reverse the overall array
// Similar question: recover rotated array(still find two parts for reversion) --> reverse the overall array
class Solution {
    public void rotate(int[] nums, int k) {
        // make sure k is in the bound of the array
        k = k % nums.length;
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
