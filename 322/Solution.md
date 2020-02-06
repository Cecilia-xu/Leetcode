# Solution 1: from youtube
```Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            // initialization: in order to find the min
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                // corner case! i >= coins[j] avoid array out-of-bound error
                // dp[i - coins[j]] != Integer.MAX_VALUE avoid integer overflow error
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    // loops to find the min dp[i] 
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]); 
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
```
