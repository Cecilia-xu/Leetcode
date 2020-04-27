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
