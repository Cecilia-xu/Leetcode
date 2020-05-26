// Solution: binary tree + divide and conquer
// Time complexity: O(n)
// Space complexity: O(h)
// Note: LCA question: decide by the position of p and q (3 cases)
// Case 1: if p and q on the different side of the tree OR p or q is the root, LCA -> root
// Case 2: if both p and q are on the left side of the tree, find LCA on the left subtree.
// Case 3: if both p and q are on the right side of the tree, find LCA on the right subtree.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // case 3
        if (left == null) {
            return right;
        }
        // case 2
        else if (right == null) {
            return left;
        }
        // case 1
        else {
            return root;
        }
    }
}
