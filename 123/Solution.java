// Solution: dp
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // before ith day state (1 ... 5)
        int[][] f = new int[len + 1][6];
        // initialize
        f[0][1] = 0;
        for (int j = 2; j < 6; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            // state 1, 3, 5
            for (int j = 1; j <= 5; j += 2) {
                f[i][j] = f[i - 1][j];
                if (i >= 2 && j > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }   
            }
            
            // state 2, 4
            for (int j = 2; j <= 5; j += 2) {
                f[i][j] = f[i - 1][j - 1];
                if (i >= 2 && f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i - 1][j] + prices[i - 1] - prices[i - 2], f[i][j]);
                }
            }
        }
        
        return Math.max(f[len][1], Math.max(f[len][3], f[len][5]));
    }
}
