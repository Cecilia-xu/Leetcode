// Solution: dynamic programming
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        int[] curMoney = new int[nums.length + 1];
        curMoney[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == 1) {
                curMoney[i] = nums[i - 1];
            }
            else {
                curMoney[i] = Math.max(curMoney[i - 1], curMoney[i - 2] + nums[i - 1]);
            }
        }
        return curMoney[nums.length];
    }
}


// Solution: dp with optimized space
class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;
        for (int n : nums) {
            int temp = currMax;
            currMax = Math.max(n + prevMax, currMax);
            prevMax = temp;
        } 
        return currMax;
    }
}
