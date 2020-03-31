// Solution1: Recursion
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorderList = new ArrayList<>();
        if (root == null) {
            return postorderList;
        }
        postorderHelper(root, postorderList);
        return postorderList;
    }
    public void postorderHelper(TreeNode root, List postorderList) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, postorderList);
        postorderHelper(root.right, postorderList);
        postorderList.add(root.val);
    }
}

// Solution2: Iteration - use arraylist
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                else if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            else if (prev == curr.left) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}
