// Solution 1: brute force: recursion + divide and conquer (not use any property of completer binary tree)
// Time complexity: O(n)
// Space complexity: O(H)= O(logn). This is a complete binary tree. The height of binary tree is logn.
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
// Solution 2: Binary search(nested)
// Time complexity: O(logn * logn) = O((logn)^2). Because we did binary search on [0, n - 1] and during each binary search,
// we called checkExistence in O(logn) -> O(logn) * O(logn)
// Space complexity: O(1)
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = level(root);
        if (l == 1) {
            return 1;
        }
        int left = 0, right = (int)Math.pow(2, l - 1) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkExistence(root, l - 1, mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left + (int)Math.pow(2, l - 1) - 1;
    }
    
    // Time: O(logn)
    private int level(TreeNode root) {
        int level = 0;
        TreeNode cur = root;
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level;
    }
    
    //Time: O(log(2^depth)) = O(log(2^logn)) = O(logn)
    private boolean checkExistence(TreeNode root, int depth, int idx) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        TreeNode target = root;
        for (int i = 0; i < depth; i++) {
            int pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                target = target.left;
                right = pivot;
            }
            else {
                target = target.right;
                left = pivot + 1;
            }
        }
        return target != null;
    }
}
