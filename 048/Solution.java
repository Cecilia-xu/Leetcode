// Solution: array
// Time complexity: O(m * n)
// Space complexity: O(1)
/*
 * rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = row - 1;
        // reverse
        while (i < j) {
            for (int k = 0; k < col; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
            i++;
            j--;
        }
        
        // swap 
        for (int m = 0; m < row; m++) {
            for (int n = m; n < col; n++) {
                int temp = matrix[m][n];
                matrix[m][n] = matrix[n][m];
                matrix[n][m] = temp;
            }
        }
    }
}
