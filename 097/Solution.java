// Solution: DP
// Time complexity: O(m * n) m = s1.length(), n = s2.length()
// Space complexity: O(m * n)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        }
        else if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int len1 = s1.length(), len2 = s2.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }              
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
