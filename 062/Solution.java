// Solution: dynamic programming
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathCount = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // edge case
                if (i == 0 || j == 0) {
                    pathCount[i][j] = 1;
                }
                else {
                    pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
                }
            }
        }
        return pathCount[m - 1][n - 1];
    }
}
