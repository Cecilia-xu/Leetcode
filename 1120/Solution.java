// Solution: Recursion(bottom-up) + Traversal(postorder/in maximumAverageSubtree method) + Divide and Conquer(in helper method)
// Time complexity: O(n). Visited each node once to find the answer(customized type: ResultType) in O(1) -> n * O(1) = O(n)
// Space complexity: O(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    public int sum;
    public int count;
    public ResultType(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Solution {
    public double maxAverage;
    public double maximumAverageSubtree(TreeNode root) {
        maxAverage = Double.NEGATIVE_INFINITY;
        helper(root);
        return maxAverage;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        double average = (double) sum / count;
        maxAverage = Math.max(maxAverage, average);
        return new ResultType(sum, count);
    }
}
