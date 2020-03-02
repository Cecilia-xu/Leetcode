// Solution 1: inorder traversal + O(h) space
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
    private Integer target;
    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        target = null;
        inorderSearch(root);
        return target;
    }
    
    private void inorderSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderSearch(root.left);
        count--;
        if (count == 0) {
            target = root.val;
            return;
        }
        inorderSearch(root.right);
    }
}

// Solution 2: inorder traversal + O(n) space
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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorderList = new ArrayList<Integer>();
        if (root == null) {
            return -1;
        }
        inorderTraversal(root, inorderList);
        return inorderList.get(k - 1);
    }
    
    public void inorderTraversal(TreeNode root, ArrayList<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }
}
