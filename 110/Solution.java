// Solution 1: recursion + divide and conquer(top - down) (not the best solution)
// Time complexity: O(nlogn). This is because the method we recursively called is O(n) in each level. The number of levels 
// is depended on the height of the recursion tree. For examle, if the tree is a complete binary tree. The height is logn. 
// The time complexity should be O(nlogn). -> When the tree is skewed, the recursion function we called will stop early. The
// time complexity is only O(n).
// Space complexity: O(H)
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// Solution 2: recursion + traversal(post order) + divide and conquer (bottom-up)
// Time complexity: O(n)
// Space complexity: O(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
final class ResultType {
    public int height;
    public boolean balanced;
    public ResultType(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root).balanced;
    }
    
    public ResultType height(TreeNode root) {
        if (root == null) {
            return new ResultType(-1, true);
        }
        ResultType left = height(root.left);
        ResultType right = height(root.right);
        if (Math.abs(left.height - right.height) > 1 || !left.balanced || !right.balanced) {
            return new ResultType(-1, false);
        }
        else {
            return new ResultType(Math.max(left.height, right.height) + 1, true);
        }
    }
}
// Solution 3: Optimization of solution 2
// Time complexity: O(n)
// Space complexity: O(H)
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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        if (left == -1) {
            return -1;
        }
        int right = height(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        else {
            return Math.max(left, right) + 1;
        }
    }
}
