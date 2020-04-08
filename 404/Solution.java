// Solution 1: Recursion + divide and conquer
// Note: one more base case: when the root of the subtree is a left leaf node
// Time complexity: O(N)
// Space compleity: O(H). Worst case : O(n)
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
     }
    
    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
