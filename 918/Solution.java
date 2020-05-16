// Solution: Subarray(greedy)
// Refer to: https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int globalMax = Integer.MIN_VALUE, globalMin = Integer.MAX_VALUE;
        int curMax = 0, curMin = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            curMax = Math.max(curMax + A[i], A[i]);
            globalMax = Math.max(curMax, globalMax);
            curMin = Math.min(curMin + A[i], A[i]);
            globalMin = Math.min(curMin, globalMin);
            sum += A[i];
        }
        
        return sum != globalMin ? Math.max(globalMax, sum - globalMin) : globalMax;
    }
}
