// Solution 1: Brute Force(Very ugly solution)
// Time complexity: O((mn)^2). m * n for listing all top-left points. For each point, check the square and area needs O(mn) -> O(m^2n^2)
// Space complexity: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int length = searchRow(matrix, i, j);
                    while (length * length > res) {
                        res = Math.max(res, isSquare(matrix, i, j, length));
                        length--;
                    }
                }
            }
        }
        return res;
    }
    
    private int searchRow(char[][] matrix, int x, int y) {
        for (int j = y + 1; j < matrix[0].length; j++) {
            if (matrix[x][j] == '1') {
                return 1 + searchRow(matrix, x, y + 1);
            }
        }
        return 1;
    }
    
    private int isSquare(char[][] matrix, int x, int y, int length) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (!inArea(i, j, row, col) || matrix[i][j] != '1') {
                    return -1;
                }
            }
        }
        return length * length;
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

// Solution 2: dynamic programming (Very impressive!)
// Note: The answer of the subproblem may not be the direct answer of the main problem! We can solve it indirectly.
// In this question, we use dp to find the side length of the square.
// Time complexity: O(mn)
// Space complexity: O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int dp[][] = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            } 
        }
        return res * res;
    } 
}

// Solution 3: DP with space optimization
// Time complexity: O(m * n)
// Space complexity: O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        // Because we find that dp[i][j] is only related with dp[i - 1], use two rows for dp array
        int dp[][] = new int[2][col + 1];
        int cur = 0, pre = 1;
        for (int i = 1; i <= row; i++) {
            // change cur and pre
            int temp = cur;
            cur = pre;
            pre = temp;
            
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[cur][j] = Math.min(dp[pre][j], Math.min(dp[pre][j - 1], dp[cur][j - 1])) + 1;
                    res = Math.max(res, dp[cur][j]);
                }
                else {
                    dp[cur][j] = 0;
                }
            } 
        }
        return res * res;
    } 
}
