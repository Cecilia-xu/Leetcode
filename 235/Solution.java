// Solution: Tree + divide and conquer
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
        // if p and q are in the different subtree 
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
            return root;
        }
        // if p and q are in the same substree
        else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
