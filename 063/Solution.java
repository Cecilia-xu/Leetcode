// Solution: dynamic programming
// Time complexity: O(n*m)
// Space complexity: O(n*m)
// Analysis: 
// If the grid cell is an obstacle, the path count must be 0. (decide it first)
// Else, we think about the top-left case: because when it is 1, we do not need to assign 0 to this cell.
// Else, we consider the edge cases: when row = 0 or col = 0
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] pathCount = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // obstacle
                if (obstacleGrid[i][j] == 1) {
                    pathCount[i][j] = 0;
                }
                //left-top
                else if (i == 0 && j == 0) {
                    pathCount[i][j] = 1;
                }
                else {
                    pathCount[i][j] = 0;
                    if (i > 0) {
                        pathCount[i][j] += pathCount[i - 1][j];
                    }
                    if (j > 0) {
                        pathCount[i][j] += pathCount[i][j - 1];
                    }
                }
            }
        }
        return pathCount[row - 1][col - 1];
    }
}
