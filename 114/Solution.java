// Solution 1: Recursion + in place
// Time complexity: O(n). visited each node to flatten(solve subquestion) in O(1)  -> n * O(1) = O(n)
// Space complexity: O(H). Worst case: O(n)
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
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = flattenHelper(root.left);
        TreeNode rightLast = flattenHelper(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null) {
            return rightLast;
        } 
        else if (leftLast != null) {
            return leftLast;
        }
        else {
            return root;
        }
    }
}
