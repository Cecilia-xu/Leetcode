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
// Solution 2: Recursion + Traversal
// Time complexity: O(n)
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
class Solution {
    public int depth = 0;
    
    public int maxDepth(TreeNode root) {
        traverse(root, 1); // Note: root should be depth = 1
        return depth;
    }
    
    private void traverse(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        depth = Math.max(depth, curDepth);
        traverse(root.left, curDepth + 1);
        traverse(root.right, curDepth + 1);
    }
}
