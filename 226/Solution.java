// Solution: recursion + divide and conquer
// TIme complexity:O(n). Visit each node once and invert in O(1).
// Space complexity: O(H). Worst case: O(n). When the tree is skewed.
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightNode = invertTree(root.left);
        TreeNode leftNode = invertTree(root.right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
