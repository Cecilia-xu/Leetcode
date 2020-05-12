// Solution: DP
// Time complexity: O(m * n). m = word1.length(), n = word2.length()
// Space complexity: O(m * n)
class Solution {
    public int minDistance(String word1, String word2) {
        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();
        int len1 = letters1.length, len2 = letters2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                
                // delete & insert
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                // replace
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
