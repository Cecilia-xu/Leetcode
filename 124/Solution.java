// Solution 1: Divide and conquer(my ugly solution)
// Time complexity: O(n)
// Space complexity: O(H)
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
    // Define a class to store the possible variables we need to recursively use
    public class ResultType {
        // pathSum represents the maximal pathSum we found so far and this pathsum can be expanded in the future (left path - root, right path - root, root)
        public int pathSum;
        // currentMaxPath represent the solution for the subproblem
        // currentMaxPath should be the maximum of pathSum, the closed paths (left path - root- right path, closed left path, closed right path)
        public int currentMaxPath;
        public ResultType(int pathSum, int currentMaxPath) {
            this.pathSum = pathSum;
            this.currentMaxPath = currentMaxPath;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).currentMaxPath;
    }
    
    // Tricky points: the value of treenode can be negative, how can we deal with this?
    public ResultType maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        // deal with the root whose children are null. (Since the root's value can be negative)
        if (root.left == null && root.right == null) {
            return new ResultType(root.val, root.val);
        }
        
        // find the results for the subproblems
        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);
        
        // construct result
        int pathSum, currentMax;
        
        // discuss case 1: root.left == null (deal with negative case)
        if (root.left == null) {
            pathSum = Math.max(right.pathSum + root.val, root.val);
            currentMax= Math.max(pathSum, Math.max(right.currentMaxPath, right.pathSum + root.val));
        }
        // discuss case 2: root.right == null
        else if (root.right == null) {
            pathSum = Math.max(left.pathSum + root.val, root.val);
            currentMax= Math.max(pathSum, Math.max(left.currentMaxPath, left.pathSum + root.val));
        }
        // discuss case 3: normal cases
        else {
            // path sum: maximum path sum within paths that are still open to add nodes
            pathSum = Math.max(Math.max(left.pathSum, right.pathSum) + root.val, root.val);
            // find current max: (1) pathSum (2) current max we found before (3) closed path (left path - root - right path)
            currentMax= Math.max(pathSum, Math.max(Math.max(left.currentMaxPath, right.currentMaxPath), left.pathSum + right.pathSum + root.val));
        }

        return new ResultType(pathSum, currentMax);
    }
}

// Solution 2: Traversal(learnt from the official solution)
// Time complexity: O(n)
// Space complexity: O(H)
// Notes: We do not need to know the specific result for each subproblem. We can just update the result by comparing result and
// the path whose path sum is maximal among all closed path. And return the maximal path sum of the path that can add nodes.
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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        currentMaxPathSum(root);
        return max;
    }
    
    public int currentMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 注意这个0的处理：如果发现负值，我们宁肯不加这条path，为了不让path sum变得更小
        int left = Math.max(currentMaxPathSum(root.left), 0);
        int right = Math.max(currentMaxPathSum(root.right), 0);
        // 打擂台（全局最大 & 当前最大）
        max = Math.max(left + right + root.val, max);
        // return 当前依然能扩展的path的最大path sum
        return Math.max(left,right) + root.val;
    }
}
