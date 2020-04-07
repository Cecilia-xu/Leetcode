// Solution: recursion + divide and conquer
// Time complexity: O(n)
// Sapce comlexity: O(h)
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isTwoSymmetric(root.left, root.right);
    }
    
    private boolean isTwoSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1 == null || root2== null) {
            return false;
        }
        else if (root1.val != root2.val) {
            return false;
        }
        return isTwoSymmetric(root1.left, root2.right) && isTwoSymmetric(root2.left, root1.right);
    } 
}
