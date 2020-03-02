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
