// Time coplexity: O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start, end = 0;
        int sum = 0;
        for (start = 0; start < nums.length; start++) {
            while (sum < s && end < nums.length) {
                sum += nums[end];
                end++;
            }
            if (sum >= s) {
                ans = Math.min(ans, end - start);
                sum -= nums[start];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
