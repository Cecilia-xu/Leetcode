// Solution: dynamic programming
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // situation 1
        int preMax1 = 0, currMax1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = currMax1;
            currMax1 = Math.max(preMax1 + nums[i], currMax1);
            preMax1 = temp;
        }
        
        //situation 2
        int preMax2 = 0, currMax2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax2;
            currMax2 = Math.max(preMax2 + nums[i], currMax2);
            preMax2 = temp;
        }
        
        return Math.max(currMax1, currMax2);
    }
}
