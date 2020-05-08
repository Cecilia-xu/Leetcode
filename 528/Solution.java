// Solution: Random + Binary search
class Solution {
    public int[] preSum;
    public Random rd;
    public int upperBound;
    
    // O(n)
    public Solution(int[] w) {
        preSum = new int[w.length];
        rd = new Random();
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];   
        }
        upperBound = preSum[w.length - 1];
    }
    
    // O(logn)
    public int pickIndex() {
        int target = rd.nextInt(upperBound);
        int left = 0, right = preSum.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (preSum[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
