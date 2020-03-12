// Solution 1: BFS
// Note: use linkedlist not arraylist because linkedlist can avoid the moves of the elements when the arraylist is full
// Note: list.add(int index, <E>) can add an element to a specific position(== index) and move all the other elements from this index back automatically.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelRes.add(node.val);
            }
            res.add(0, levelRes);
        }
        return res;
    }    
}

// Solution 2: Recursion + DFS
// Recursion + Traversal: helper method should return void and create the final result as a global data type in the class
// BFS is different from the other traversal, since the relationship we should focus on is level, not the root and its successors.
// Use DFS to the last level of tree and create the arraylists(the number of arraylists is as same as the level) in the final result lists.
// Add the node to specific arraylists(the last level: get(0), ... the first level: get(level - 1))
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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(0, new ArrayList<Integer>());
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}
