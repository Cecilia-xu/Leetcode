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
