// Solution: Recursion + Divide and Conquer
// Time complexity: O(n)
// Space complexity: O(H). H is the height of the tree. In the worst case, all the node are on the left side of each level, O(n)
// In the best case, the tree is balanced, O(logn).
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
