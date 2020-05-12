// Solution: DP
// Time complexity: O(m * n). m = s.length(), n = t.length()
// Space complexity: O(m * n)
class Solution {
    public int numDistinct(String s, String t) {
        char[] words1 = s.toCharArray();
        char[] words2 = t.toCharArray();
        int len1 = words1.length, len2 = words2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j]; 
                }
                if (i > 0 && j > 0 && words1[i - 1] == words2[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
             }
        }
        return dp[len1][len2];
    }
}
