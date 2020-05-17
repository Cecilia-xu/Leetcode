// Solution: DP
// Analysis: dp[i] means the maxmium product we can get for i. Since i is a positive number, i starts from 1, dp[1] = 1.
// If i = j + (i - j), which means dp[i] = max(j * (i - j), dp[i- j] * j), j < i
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    // 2 = 1 + 1 -> 1
    // 3 = 1 + 2 -> 2
    // 4 = 2 + 2 -> 4
    // 5 = 2 + 3 -> 6
    // 6 = 3 + 3 -> 9
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}
