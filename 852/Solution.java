class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid + 1] > A[mid]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        
        if (A[left] < A[right]) {
            return right;
        }
        else {
            return left;
        }
    }
}
