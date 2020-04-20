// Solution: dp(sequence type in grid)
// Time complexity: O(m * n)
// Sapce complexity: O(m * n)
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        //* Note: Do not forget the empty array
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int row = grid.length, col = grid[0].length;
        
        // 4 different directions
        int[][] up = new int[row][col];
        int[][] down = new int[row][col];
        int[][] left = new int[row][col];
        int[][] right = new int[row][col];
        
        // calculate up[] and left[]
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    left[i][j] = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    up[i][j] += 1;
                    left[i][j] += 1;
                }
                //*Note: do not make the index out of bound!
                up[i][j] += i > 0 ? up[i - 1][j] : 0;
                left[i][j] += j > 0 ?left[i][j - 1] : 0;  
            }
        }
        
        // calculate down[] and right[]
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    right[i][j] = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    down[i][j] += 1;
                    right[i][j] += 1;
                }
                // *Note: do not make the index out of bound!
                down[i][j] += i < row - 1 ? down[i + 1][j] : 0;
                right[i][j] += j < col - 1? right[i][j + 1] : 0;
            }
        }
        
        // Find the maximum
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    int killCount = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    res = Math.max(res, killCount);
                }
            }
        }
        
        return res;
    }
}
