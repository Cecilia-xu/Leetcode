// Very interesting question! -> think about how to optimize space step by step!:D
// Solution 1: 2d DP
// Time complexity: O(n * m)
// Space complexity: O(n * m)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] minPath = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    minPath[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    minPath[i][j] = minPath[i][j - 1] + grid[i][j];
                }
                else if (j == 0) {
                    minPath[i][j] = minPath[i - 1][j] + grid[i][j];
                }
                else {
                    minPath[i][j] = Math.min(minPath[i][j - 1], minPath[i - 1][j]) + grid[i][j];
                }
            }
        }
        return minPath[row - 1][col - 1];
    }
}

// Solution 2 - 1: 1d DP - use 2 pointers: cur, pre 
// Time complexity: O(n * m)
// Space complexity: O(n * 2) -> O(n)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] minPath = new int[2][col];
        int cur = 1, pre = 0;
        for (int i = 0; i < row; i++) {
            // swap
            int temp = pre;
            pre = cur;
            cur = pre;
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    minPath[cur][j] = grid[i][j];
                }
                else if (i == 0) {
                    minPath[cur][j] = minPath[cur][j - 1] + grid[i][j];
                }
                else if (j == 0) {
                    minPath[cur][j] = minPath[pre][j] + grid[i][j];
                }
                else {
                    minPath[cur][j] = Math.min(minPath[cur][j - 1], minPath[pre][j]) + grid[i][j];
                }
            }
        }
        return minPath[cur][col - 1];
    }
}
// Solution 2 - 2: use mod
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] minPath = new int[2][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    minPath[i % 2][j] = grid[i][j];
                }
                else if (i == 0) {
                    minPath[i % 2][j] = minPath[i % 2][j - 1] + grid[i][j];
                }
                else if (j == 0) {
                    minPath[i % 2][j] = minPath[1 - i % 2][j] + grid[i][j];
                }
                else {
                    minPath[i % 2][j] = Math.min(minPath[i % 2][j - 1], minPath[1 - i % 2][j]) + grid[i][j];
                }
            }
        }
        return minPath[(row - 1) % 2][col - 1];
    }
}

// Solution 3: in-place DP
// Time complexity: O(n * m)
// Space complexity: O(1)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[row - 1][col - 1];
    }
}
