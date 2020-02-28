// Solution 1: BST inorder traversal
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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrderTraversal = inOrder(root);
        if (inOrderTraversal.size() <= 1) {
            return true;
        }
        for (int i = 1; i < inOrderTraversal.size(); i++) {
            if (inOrderTraversal.get(i) <= inOrderTraversal.get(i -1)) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inOrderHelper(root, res);
        return res;
    }
    
    private void inOrderHelper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, res);
        res.add(root.val);
        inOrderHelper(root.right, res);
    }
}
