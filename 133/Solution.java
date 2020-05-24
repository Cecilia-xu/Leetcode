// Solution 1: bfs
// Similar question: 138. Copy List with Random Pointer -> use hashmap to create the relationship between origin node and
// cloned node (if exists, the node has been created and its neighbors has been added into the queue)
// Time complexity: O(n)
// Space complexity: O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node newNode = new Node(node.val);
        queue.add(node);
        oldToNew.put(node, newNode);
        
        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            Node newVertex = oldToNew.get(vertex);
            List<Node> oldNeighbors = vertex.neighbors;
            
            for (Node oldNeighbor : oldNeighbors) {
                if (!oldToNew.containsKey(oldNeighbor)) {
                    Node newNeighbor = new Node(oldNeighbor.val);
                    queue.add(oldNeighbor);
                    oldToNew.put(oldNeighbor, newNeighbor);
                }
                newVertex.neighbors.add(oldToNew.get(oldNeighbor));
            }
        }
        
        return newNode;
    }
}
// Solution 2: DFS (not the best one, might stack overflow if the depth of recusrion is large)
// Time: O(n)
// Space: O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for (Node nei : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(nei));
        }
        
        return cloneNode;
    }
}
