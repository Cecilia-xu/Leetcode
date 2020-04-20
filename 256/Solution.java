// Solution: sequence type DP
// Time complexity: O(n)
// Space complexity: O(1)
// Equation: cost[i][0] = min(cost[i - 1][1], cost[i -1][2]) + cost[i][0], ...
// Reference: sample question on Notes No.2
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        
        return Math.min(Math.min(costs[costs.length - 1][0],costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
