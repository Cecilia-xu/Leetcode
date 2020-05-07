// Similar question 1: (leetcode 221 maximal square)
// Solution 1: 2D DP
// Notes: 1) Definition: dp[i][j] means the current max width when ended by matrix[i][j] in i-th row
//2) equation: dp[i][j] = dp[i][j - 1] + 1 | matrix[i][j] = '1' (when j = 0, j - 1 out of bound, assign dp[i][0] = 1)
//3) make matrix[i][j] at lower right corner and find all areas of possible rectangles whose lower right corner is matrix[i][j]
// Time complexity: O(n^ 2 * m). m is row, n is column.
// Space complexity: O(n * m)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // the max width when the index of col is ended by j and in row i
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 1 : dp[i][j - 1] + 1);
                    
                    int width = Integer.MAX_VALUE;
                    // the possible rectangle's areas when matrix[k][j] is the lower right corner
                    for (int k = i; k >= 0 && matrix[k][j] == '1'; k--) {
                        // width is currenet width 
                        width = Math.min(dp[k][j], width);
                        // i - k + 1 is current height
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
                
            }
        }
        return maxArea;
    }
}

// Solution 2: Monotonic stack
// Time complexity: O(m * n). O(m * n)for filling heights array + O(m * n) for findmaxArea methods.
// Space complexity: O(m * n). O(n) stack for m times. O(n) height array
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[] heights = new int[col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                }
                else {
                    heights[j]++;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(heights));
        }
        return maxArea;
    }
    
    // totally same with leetode 84 O(n)
    private int findMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        stack.push(0);
        for (int i = 1; i <= heights.length; i++) {
            int height = (i == heights.length ? -1 : heights[i]);
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int index = stack.pop();
                int area = (!stack.isEmpty() ? heights[index] * (i - stack.peek() - 1) : heights[index] * i);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
