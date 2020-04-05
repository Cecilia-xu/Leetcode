// Solution 1: recursion + divide and conquer (not the optimal solution)
// Time complexity: O(n)
// Space complexity: O()
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> path = new LinkedList<Integer>();
            path.add(root.val);
            result.add(path);
            return result;
        }
        List<List<Integer>> leftPath = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightPath = pathSum(root.right, sum - root.val);
        
        for (List<Integer> list : leftPath) {
            List<Integer> path = new LinkedList<>();
            path.add(root.val);
            path.addAll(list);
            result.add(path);
        }
        
        for (List<Integer> list : rightPath) {
            List<Integer> path = new LinkedList<>();
            path.add(root.val);
            path.addAll(list);
            result.add(path);
        }
        
        return result;
    }
}
