// Solution 1: divide and conquer + binary search
// Time complexity: O(nlogn)
// Space complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return new TreeNode();
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
    
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        // find the first element's index whose value is larger than val
        int rightStart = binarySearch(preorder, start + 1, end, val);
        root.left = helper(preorder, start + 1, rightStart - 1);
        root.right = helper(preorder, rightStart, end);
        return root;
    }
    
    private int binarySearch(int[] preorder, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preorder[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

}
// Solution 2: divide and conquer + upperBound
// Time complexity: O(n)
// Space complexity: O(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return new TreeNode();
        }
        this.index = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }
        int val = preorder[index];
        TreeNode root = new TreeNode(val);
        index++;
        root.left = helper(preorder, val);
        root.right = helper(preorder, upperBound);
        return root;
    }

}
