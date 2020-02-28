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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return sortedArrayHelper(nums, 0, nums.length - 1);
    }
    
    public TreeNode sortedArrayHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayHelper(nums, left, mid - 1);
        root.right = sortedArrayHelper(nums, mid + 1, right);
        return root;
    }
}
