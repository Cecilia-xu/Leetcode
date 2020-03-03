// Solution 1: inorder traversal --> Two Sum II
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
    private List<Integer> nums;
    public boolean findTarget(TreeNode root, int k) {
        nums = new ArrayList<Integer>();
        inorder(root);
        if (nums.size() < 2) {
            return false;
        }
        int start = 0, end = nums.size() - 1;
        while (start < end) {
            if (nums.get(start) + nums.get(end) == k) {
                return true;
            }
            else if (nums.get(start) + nums.get(end) > k) {
                end--;
            }
            else {
                start++;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}

// Solution 2: hashset + inorder traversal
// Why hashset? No duplicate element
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
    private Set<Integer> nums;
    private int sum;
    private boolean isFound;
    public boolean findTarget(TreeNode root, int k) {
        nums = new HashSet<Integer>();
        sum = k;
        isFound = false;
        inorder(root);
        return isFound;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (nums.contains(sum - root.val)) {
            isFound = true;
        }
        nums.add(root.val);
        inorder(root.right);
    }
}
