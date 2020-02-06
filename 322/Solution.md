# Solution 1: from youtube

```Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return -1;
        }
        int[] count = new int[amount + 1];
        count[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            // initialization: in order to find the min
            count[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                // corner case! i >= coins[j] avoid array out-of-bound error
                // dp[i - coins[j]] != Integer.MAX_VALUE avoid integer overflow error
                if (i >= coins[j] && count[i - coins[j]] != Integer.MAX_VALUE) {
                    count[i] = Math.min(count[i - coins[j]] + 1, count[i]);
                }
            }
        }
        
        if (count[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return count[amount];
    }
}
```
