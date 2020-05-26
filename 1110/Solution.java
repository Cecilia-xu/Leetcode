// Solution 1: tree + divide and conquer
// Time complexity: O(n)
// Space complexity: O(h)
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : to_delete) set.add(i);
        delHelper(root, to_delete, ans, set);
        if (!set.contains(root.val)) ans.add(root);
        return ans;
    }
    
    private TreeNode delHelper(TreeNode root, int[] to_delete, List<TreeNode> ans, HashSet<Integer> set) {
        if (root == null) {
            return null;
        }
        root.left = delHelper(root.left, to_delete, ans, set);
        root.right = delHelper(root.right, to_delete, ans, set);
        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}
// Solution 2: tree + traversal
// Time complexity: O(n)
// Space complexity: O(h)
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (root == null) {
	        return result;
        }
		if (to_delete.length == 0) {
			result.add(root);
			return result;
        }
        // put all deleted value into the set
        HashSet<Integer> deletedSet = new HashSet<>();
		for (int i : to_delete) {
			deletedSet.add(i);
        }
        // traverse
        traverse(root, deletedSet, result);
        if (!deletedSet.contains(root.val)) {
	            result.add(root);
            }
        return result;
    }

	private void traverse(TreeNode root, HashSet<Integer> deletedSet, List<TreeNode> result) {
		// base case
		if  (root == null) {
	        return;
        }
	    if (root.left != null) {
	        traverse(root.left, deletedSet, result);
	        if (deletedSet.contains(root.left.val)) {
	            root.left = null;
            }
        }

        if (root.right != null) {
	        traverse(root.right, deletedSet, result);
            if (deletedSet.contains(root.right.val)) {
                root.right = null;
            }
        }

        if (deletedSet.contains(root.val)) {
            if (root.left != null && !deletedSet.contains(root.left.val)) {
	            result.add(root.left);
            }
            if (root.right != null && !deletedSet.contains(root.right.val)) {
	            result.add(root.right);
            }
        }

    }
}
