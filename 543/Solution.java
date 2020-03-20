// Intuition: update local max and compare with the global max
// Time complexity:O(n). Visited all nodes once and call findHeight method(O(1)) = n * O(1) = O(n)
// Space complexity: O(h), h is the height of the binary tree.(Call stacks)
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
    private int maxLength = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return maxLength;
    }
    
    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        maxLength = Math.max(left + right, maxLength);
        return Math.max(left, right) + 1;
    }
    
}
