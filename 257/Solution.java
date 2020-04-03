// Solution 1: recursion + divide and conquer
// Time complexity : O(n)
// Space complexity: O(H). Best case: O(logn). Worst Case: O(n)
// Note: I do not think it is a good solution because the use of String!
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        return paths;
    }
}
