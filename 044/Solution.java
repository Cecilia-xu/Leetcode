// Solution: DP
// Time complexity: O(m * n) m = s.length(), n = p.length()
// Space coplexity: O(m * n)
class Solution {
    public boolean isMatch(String s, String p) {
        char[] wordS = s.toCharArray();
        char[] wordP = p.toCharArray();
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] match = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {                
                if (i == 0 && j == 0) {
                    match[i][j] = true;  
                    continue;
                }
                
                if (i > 0 && j > 0 && (wordS[i - 1] == wordP[j - 1] || wordP[j - 1] == '?')) {
                    match[i][j] = match[i - 1][j - 1];
                }
                else if (j > 0 && wordP[j - 1] == '*') {
                    match[i][j] = match[i][j - 1];
                    if (i > 0) {
                        match[i][j] = match[i][j] || match[i - 1][j];
                    }
                }
                
            }
        }
        return match[lenS][lenP];
    }
}
