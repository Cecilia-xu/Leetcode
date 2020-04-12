// Solution 1: BFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("null,");
                continue;
            }
            res.append(node.val + ",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(parent.left);
            }
            if (i + 1 < values.length && !values[++i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
