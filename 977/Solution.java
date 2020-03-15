// Two pointers
// Solution 1: started from two largest abs numbers (complete the array in a reversed way)
class Solution {
    public int[] sortedSquares(int[] A) {
        int start = 0, end = A.length - 1;
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                res[i] = A[start] * A[start];
                start++;
            }
            else {
                res[i] = A[end] * A[end];
                end--;
            }
        }
        return res;
    }
}
// Solution 2: started from two smallest abs numbers(binary search + two pointers)
class Solution {
    public int[] sortedSquares(int[] A) {
        // Find the smallest positive number + the largest negative number: use binary search
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        int start = right, end = left;
        int index = 0;
        // Two pointers: move when the abs of the num is smaller
        int[] res = new int[A.length];
        while (start >= 0 && end < A.length) {
            if (Math.abs(A[start]) <= Math.abs(A[end])) {
                res[index++] = A[start] * A[start];
                start--;
            }
            else {
                res[index++] = A[end] * A[end];
                end++;
            }
        }
        
        while (start >= 0) {
            res[index++] = A[start]* A[start];
            start--;
        }
        
        while(end < A.length) {
            res[index++] = A[end] * A[end];
            end++;
        }
        
        return res;
    }
}
