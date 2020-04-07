// Solution 1: recursion + divide and conquer (not effecient compared with bfs)
// Time complexity: O(n). Visit each nodes once
// Space complexity: O(H). Worst case: O(n). when the tree is skewed, the height is n.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
// Solution 2: Iteration + BFS (much better)
// If the tree is unbalanced then we will find the min height when we first reach a leaf, without exploring longer paths.
// Time complexity: O(n). When tree is skewed, we need to offer and poll every nodes. -> O(n)
// Space complexity: O(n). When tree is a perfect tree, the size of queue should be the number of nodes in the last level.
// The height is logn, the number of nodes in the last level is 2^logn = n. -> O(n)
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) { 
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);                    
                }
            }
            level++;
        }
        return level;
    }
}
