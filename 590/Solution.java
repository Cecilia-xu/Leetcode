/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        postorderHelper(root, res);
        return res;
    }
    
    private void postorderHelper(Node root, ArrayList<Integer> res) {
        List<Node> children = root.children;
        for (Node n : children) {
            postorderHelper(n, res);
        }
        if (root != null) {
            res.add(root.val);
        }
    }
}
