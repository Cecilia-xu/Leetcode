// Solution 1: Recursion
// Time complexity: O(n)
// Space complexity: O(n)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        if (root == null) {
            return inorderList;
        }
        inorderHelper(root, inorderList);
        return inorderList;
    }
    public void inorderHelper(TreeNode root, List inorderList) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, inorderList);
        inorderList.add(root.val);
        inorderHelper(root.right, inorderList);
    }
}

// Solution 2: Iteration
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            current = node.right;
        }
        return result;
    }
}
