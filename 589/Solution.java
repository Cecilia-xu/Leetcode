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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        preorderHelper(root, res);
        return res;
    }
    
    public void preorderHelper(Node root, ArrayList<Integer> res) {
        if (root != null) {
            res.add(root.val);
        }
        List<Node> children = root.children;
        for (Node n : children) {
            preorderHelper(n, res);
        }
    }
}
