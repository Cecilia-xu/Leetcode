// Solution: dynamic programming
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        if (len1 < len2) {
            return longestCommonSubsequence(text2, text1);
        }
        int[][] LCS = new int[len1 + 1][len2 + 1];
        // Initialization
        for (int i = 0; i <= len1; i++) {
            LCS[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            LCS[0][j] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) { 
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    continue;
                }
                LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
            }
        }
        return LCS[len1][len2];
    }
}
