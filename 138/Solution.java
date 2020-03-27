// My Solution: iterative
// Time complexity: O(n)
// Space complexity: O(n)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> originToCopy = new HashMap<>();
        Node dummyHead = new Node(0);
        Node cur1 = head, cur2 = dummyHead;
        while (cur1 != null) {
            // copy the node
            if (!originToCopy.containsKey(cur1)) {
                cur2.next = new Node(cur1.val);
            }
            else {
                cur2.next = originToCopy.get(cur1);
            }
            // add the node into the map
            originToCopy.put(cur1, cur2.next);
            // move pointers2
            cur2 = cur2.next;
            
            //copy node.random
            if (originToCopy.containsKey(cur1.random)) {
                cur2.random = originToCopy.get(cur1.random);
            }
            else if (cur1.random == null) {
                cur2.random = null;
            }
            else {
                cur2.random = new Node(cur1.random.val);
            }
            
            // add the node into the map
            originToCopy.put(cur1.random, cur2.random);
            
            // move pointers1
            cur1 = cur1.next;
            
        }
        
        return dummyHead.next;
    }
}
