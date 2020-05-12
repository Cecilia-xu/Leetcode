// Solution: 2d DP
// Time complexity: O(m * n). m = s.length(), n = p.length() 
// Space complexity: O(m * n). dp[][]
class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        boolean[][] match = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {
                    match[i][j] = true;
                    continue;
                }
                else if (j == 0) {
                    continue;
                }
                
                // if last letters are the same, check former one
                if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                    match[i][j] = match[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    // * as zero preceding element
                    if (j > 1) {
                        match[i][j] = match[i][j - 2];
                    }
                    // * can also be multiple preceding elements
                    // In this case, we can ignore this letter in s. (* can be zero)
                    if (i > 0 && j > 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        match[i][j] = match[i][j] || match[i - 1][j];
                    }
                }
            }
        }
        return match[lenS][lenP];
    }
}
