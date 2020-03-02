// Solution 1: Recursion(best)
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
        return isValidRange(root, null, null);
    }
    
    private boolean isValidRange(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        } 
        if (min != null && root.val <= min) {
            return false;
        }
        else if (max != null && root.val >= max) {
            return false;
        }
        else {
            return isValidRange(root.left, min, root.val) && isValidRange(root.right, root.val, max);
        }
    }
}
// Solution 2: BST inorder traversal + O(n) space
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
// Solution 3: BST inorder traversal + O(h) space
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
    private Integer pre;
    private boolean isValid;
    
    public boolean isValidBST(TreeNode root) {
        pre = null;
        isValid = true;
        inorderTraversal(root);
        return isValid;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null && pre >= root.val) {
            isValid = false;
        }
        pre = root.val;
        inorderTraversal(root.right);
    }
}
