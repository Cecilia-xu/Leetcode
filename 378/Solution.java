// Solution 1: binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < matrix.length; i ++) {
                int j = 0;
                while (j < matrix[0].length && matrix[i][j] <= mid) {
                    count++;
                    j++;
                }
            }
            if (count < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
