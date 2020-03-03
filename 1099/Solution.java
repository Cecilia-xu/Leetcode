// Two Sum II Variation: two pointers
// if sum > target, end--/sum < target, start++
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int start = 0, end = A.length - 1;
        int max = Integer.MIN_VALUE;
        while (start < end) {
            int sum = A[start] + A[end];
            if (sum < K) {
                max = Math.max(max, sum);
                start++;
            }
            else {
                end--;
            }
        } 
        if (max == Integer.MIN_VALUE) {
            return -1;
        }
        return max;
    }
}
