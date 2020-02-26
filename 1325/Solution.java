**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeHelper(root, target);
    }
    
    public TreeNode removeHelper(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeHelper(root.left, target);
        root.right = removeHelper(root.right, target);
        if (root.val == target) {
            if (root.left != null || root.right != null) {
                return root;
            }
            else {
                return null;
            }
        }
        return root;
    }
}
