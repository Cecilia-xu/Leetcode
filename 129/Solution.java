// Solution 1:recursion + traversal(preorder)
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
    public int rootToLeaf = 0;
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
    public void preorder(TreeNode root, int curNum) {
        if (root == null) {
            return;
        }
        curNum = curNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            rootToLeaf += curNum;
        }
        preorder(root.left, curNum);
        preorder(root.right, curNum);
    }
}
