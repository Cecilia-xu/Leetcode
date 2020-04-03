// Solution 1: recursion + divide and conquer + String
// Time complexity : O(n)
// Space complexity: O(H). Best case: O(logn). Worst Case: O(n)
// Note: Not good enough. Because using immutable string is very costly.
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
// Solution 2: Recursion + Traversal(dfs) + stringbuilder optimization
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
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        searchPaths(root, sb, result);
        return result;
    }
    
    private void searchPaths(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append("" + root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        else {
            sb.append("->");
            searchPaths(root.left, sb, res);
            searchPaths(root.right, sb, res);
        }
        sb.setLength(len);
    }
}
