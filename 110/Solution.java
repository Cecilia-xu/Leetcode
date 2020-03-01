// Solution1: Recusion - traversal
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
    private class ResultType {
        public int height;
        public boolean isBalanced;
        public ResultType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    public ResultType helper(TreeNode root) {
        ResultType res = new ResultType(0, true);
        if (root == null) {
            return res;
        }
        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);
        if (!leftRes.isBalanced || !rightRes.isBalanced) {
            res.isBalanced = false;
        }
        if (Math.abs(leftRes.height - rightRes.height) > 1) {
            res.isBalanced = false;
        }  
        res.height = Math.max(leftRes.height, rightRes.height) + 1;
        return res;
    }
}
// Solution2: Recursion - divide and conquer
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
    private class ResultType {
        private int height;
        private boolean isBalancedTree;
        
        private ResultType(int height, boolean isBalancedTree) {
            this.height = height;
            this.isBalancedTree = isBalancedTree;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalancedTree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        ResultType res = new ResultType(0, true);
        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);
        if (!leftRes.isBalancedTree || !rightRes.isBalancedTree || Math.abs(leftRes.height - rightRes.height) > 1) {
            res.isBalancedTree = false;
        }

        res.height = Math.max(leftRes.height, rightRes.height) + 1;
        return res;
    }
    
}
