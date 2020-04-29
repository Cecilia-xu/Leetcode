// Solution 1: DP
// Related question: 221
// Note: dp[i][j] = The length of the maximal square we can built when matrix[i - 1][j - 1] is at the lower right corner
// = The number of possible square we can built when matrix[i - 1][j - 1] is at the lower right corner.
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int countSquares(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;
            int[][] dp = new int[row + 1][col + 1];
            int res = 0;
            // Note: start from 1! Not 0!
            for (int i = 1; i <= row; i++)  {
                for (int j = 1; j <= col; j++) {
                    if (matrix[i- 1][j - 1] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;     
                        res += dp[i][j];
                    }
                }
            }
        return res;
    }

}
