// Solution: dynamic programming(sequence-type)
// Time complexity: O(k) + O(nk)+ O(k) -> O(nk)
// Space complexity: O(nk)
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
        // current min cost when i houses are painted and i-th house is j color
        int[][] curMinCost = new int[n][k];
        // intialize the minCost when painting 1st house in j-th color
        for (int j = 0; j < k; j++) {
            curMinCost[0][j] = costs[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            // previous min cost (smallest, second smallest) when painting 0 ... i-1 houses
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            // corresponding index of color for i-1th house
            int index1 = -1, index2 = -1;
            
            // update previous min1,min2
            for (int j = 0; j < k; j++) {
                if (curMinCost[i - 1][j] < min1) {
                    min2 = min1;
                    index2 = index1;
                    min1 = curMinCost[i - 1][j];
                    index1 = j;
                }
                else if (curMinCost[i - 1][j] < min2) {
                    min2 = curMinCost[i - 1][j];
                    index2 = j;
                }
            }
            
            // current min cost when painting ith house in jth color
            for (int j = 0; j < k; j++) {
                // No color collision with the i-1th house in the previous min-cost plan
                if (j != index1) {
                    curMinCost[i][j] += min1 + costs[i][j];
                }
                // color collision 
                else {
                    curMinCost[i][j] += min2 + costs[i][j];
                }
            }
        }
        
        // find smallest one when paint n houses
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            res = Math.min(res, curMinCost[n - 1][j]);
        }
        return res;
    }
}
