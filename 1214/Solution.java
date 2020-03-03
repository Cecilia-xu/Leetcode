// Solution 1: inorder traversal + hashset
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> nums1 = new HashSet<>();
        HashSet<Integer> nums2 = new HashSet<>();
        inorder(root1, nums1);
        inorder(root2, nums2);
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return false;
        }
        for (Integer n : nums1) {
            if (nums2.contains(target - n)) {
                return true;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root, HashSet<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
// Solution 2: inorder + two pointers
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        inorder(root1, nums1);
        inorder(root2, nums2);
        if (nums1.size() == 0 || nums2.size() == 0) {
            return false;
        }
        int start = 0, end = nums2.size() - 1;
        while (start < nums1.size() && end >= 0) {
            if (nums1.get(start) + nums2.get(end) == target) {
                return true;
            }
            else if (nums1.get(start) + nums2.get(end) > target) {
                end--;
            }
            else {
                start++;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
