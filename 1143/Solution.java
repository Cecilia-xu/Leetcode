// Solution: dynamic programming
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] LCS = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                // empty string -> LCS = 0
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                    continue;
                }
                // case 1: the last letter in text1 is not in the LCS
                // case 2: the last letter in text2 is not in the LCS
                LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                // Note: 前i个,所以对应的位置要-1
                // Case 3: the last letters in text1 and text2 are the same.
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    LCS[i][j] = Math.max(LCS[i][j], LCS[i - 1][j - 1] + 1);
                }
            }
        }
        return LCS[len1][len2];
    }
}
