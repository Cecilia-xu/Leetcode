// Solution: inorder traversal + O(n) space
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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < inorderList.size(); i++) {
            min = Math.min(inorderList.get(i) - inorderList.get(i - 1), min);
        }
        return min;
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
// Solution 2: inorder traversal + O(h) complexity
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
    private int min;
    private Integer pre;
    
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = null;
        inorderTraversal(root);
        return min;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(pre - root.val));
        }
        pre = root.val;
        inorderTraversal(root.right);
    }
}
