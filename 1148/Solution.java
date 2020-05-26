// Solution: Tree
// Time complexity: O(n)
// Space complexity: O(h)
// Notes: For this question, we can focus on the node whose value is the maximum in the path.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public int count;
    public int goodNodes(TreeNode root) {
        if (root == null) {
	        return 0;
        }
        count = 0;
        inorder(root, Integer.MIN_VALUE);
        return count;
    }
    
	private void inorder(TreeNode root, int max) {
      // base case 
		  if (root == null) {
			  return;
      }
		  // check root
		  if (root.val >= max) {
			  count++;
			  max = Math.max(max, root.val);
       }
      // left subtree
      if (root.left != null) {
        inorder(root.left, max);
      }
      // right subtree
      if (root.right != null) {
        inorder(root.right, max);
      }
    }
}
