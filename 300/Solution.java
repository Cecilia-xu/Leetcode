// Solution1: O(n^2) DP (longest sequence type -> essence: index type dp) -> not the best solution
// Definition: length[] means the longest length of sequence ended with nums[i]
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] length = new int[nums.length];
        length[0] = 1;
        int res = length[0];
        for (int i = 1; i < nums.length; i++) {
            length[i] = 1;
            // find all former elements that is smaller than nums[i], and update max length
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
            
            // update result if find any larger length
            if (length[i] > res) {
                res = Math.max(res, length[i]);
            }
        }
        
        return res;
    }
}
