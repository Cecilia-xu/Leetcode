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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesValues1 = new ArrayList<>();
        List<Integer> leavesValues2 = new ArrayList<>();
        findLeaves(leavesValues1, root1);
        findLeaves(leavesValues2, root2);
        return isSimilar(leavesValues1, leavesValues2);
    }
    
    private void findLeaves(List<Integer> leavesValues, TreeNode root) {
        if (root == null) {
            return;
        } 
        if (root.left == null && root.right == null) {
            leavesValues.add(root.val);
        }
        findLeaves(leavesValues, root.left);
        findLeaves(leavesValues, root.right);
    }
    
    private boolean isSimilar(List<Integer> values1, List<Integer> values2) {
        if (values1.size() != values2.size()) {
            return false;
        }
        for (int i = 0; i < values1.size(); i++) {
            if (values1.get(i) != values2.get(i)) {
                return false;
            }
        }
        return true;
    }
    
}
