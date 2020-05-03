// Solution 1: Math
class Solution {
    public boolean canWinNim(int n) {
        if (n == 0) {
            return false;
        }
        return (long)n % 4 == 0 ? false : true;
    }
}

// Solution 2: DP(overflow when n is very large -> GAME TYPE DP)
// Main problem: when facing n stones, will win or not?
// Sub problem: when facing n-1, n-2, n-3 stones, will win or not?
// If another person may lose when facing n-1, or n-2, or n-3 stones, the first guy must win.
// dp[i] = (! dp[i - 1] || !dp [i - 2] || !dp[i - 3])
class Solution {
    public boolean canWinNim(int n) {
        if (n == 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = (!dp[i - 1] || !dp[i - 2] || !dp [i - 3]);
        }
        return dp[n];
    }
}
