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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return constructHelper(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
    
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIdx] < nums[i]) {
                maxIdx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructHelper(nums, start, maxIdx - 1);
        root.right = constructHelper(nums, maxIdx + 1, end);
        return root;
    }
}
