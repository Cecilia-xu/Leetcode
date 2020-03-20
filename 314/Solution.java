// Solution 1
// The idea is to level order traverse the tree and for each node we assign a weight to it.
// We first assign root with weight 0.
// For any given node with weight w, we assign w - 1 to its left child and w + 1 to its right child.
// In this way, we level order traverse all the nodes, and put all the nodes to their assigned weight list.
// Finally, we add all lists to the result.
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> weightToNums = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int max = 0, min = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> weights = new LinkedList<>();
        queue.offer(root);
        weights.offer(0);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int weight = weights.poll();
            if (!weightToNums.containsKey(weight)) {
                weightToNums.put(weight, new ArrayList<Integer>());
            }
            weightToNums.get(weight).add(node.val);
            min = Math.min(weight, min);
            max = Math.max(weight, max);
            if (node.left != null) {
                queue.add(node.left);
                weights.add(weight - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weights.add(weight + 1);
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(weightToNums.get(i));
        }
        
        return res;
    }
}
