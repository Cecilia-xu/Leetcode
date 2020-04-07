// Solution 1: recursion + divide and conquer
// Time complexity: O(n). Visit each nodes once
// Space complexity: O(H). Worst case: O(n). when the tree is skewed, the height is n.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
