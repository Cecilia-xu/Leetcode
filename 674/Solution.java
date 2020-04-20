// Solution: 1D dp (sequence type)
// Time complexity: O(n)
// Space complexity: O(n)
// Notes: dp[i] means when ended with nums[i], the current length of LCIS. 
// If the sequence is still increasing, dp[i] = dp[i - 1] + 1.
// If not, dp[i] = 1
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// Solution 2: dp (optimize space)
// Time complexity: O(n)
// Space complexity: O(1)
// Notes: use curLen instead of dp[i]
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                curLen += 1;
            }
            else {
                curLen = 1;
            }
            max = Math.max(max, curLen);
        }
        return max;
    }
}

// Solution 3: sliding window
// Time complexity: O(n)
// Space complexity: O(1)
// current length = end - start (if [start, end] is valid). Fix start, increase end.(start = i when num[i] >= nums[i - 1])
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, start = 0;
        for (int end = 0; end < nums.length; ++end) {
            if (end > 0 && nums[end - 1] >= nums[end]) {
                start = end;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
