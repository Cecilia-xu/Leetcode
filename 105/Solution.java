// Solution: binary tree + divide and conquer
// Time complexity: O(n)
// Space complexity: O(n). HashMap caching.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, valToIndex);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        // base case: already checked all elements in the range
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        
        // create the root node
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        // get the index of the root in the inorder array
        int rootPos = map.get(val);
        // get the size of nodes in the left subtree
        int leftSize = rootPos - inStart;
        
        // find the root of left subtree
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftSize, inStart, rootPos - 1, map);
        // find the root of right subtree
        root.right = helper(preorder, inorder, preStart + leftSize + 1, preEnd, rootPos + 1, inEnd, map);
        
        return root;
    }
}
