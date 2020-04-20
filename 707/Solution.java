// Design Linked List, including get(index), addAtHead(), addAtTail(), addAtIndex(index, val), delete(index)
// Implementation: 1) define and implement class ListNode 2) define global variables
// Frequent mistakes: 1) forget to maintain size 2) repeate to maintain size 3)forget to check invalid cases
class MyLinkedList {

    // *Note: do not write bracket while declaring a class!!
    public class ListNode{
        public int val;
        public ListNode next;
        // constructor
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    
    // global variables
    public int size;// count the ListNodes
    public ListNode head; // define the head of the list
    public ListNode tail; // define the tail of the list
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        return findNode(index).val;
    }
    
    
    // Time complexity: O(1)
    // Implementation: 1) create a new head node 2)assign this.head 3)this.size++
    // Note: when we add the head node is the first node in the list -> don't forget to assign this.tail  
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode headNode = new ListNode(val);
        headNode.next = this.head;
        this.head = headNode;
        this.size++;
        if (this.size == 1) {
            this.tail = headNode;
        }
    }
    
    // Time: O(1)
    // Implementation: 1) if it is the first node need to be added -> use addAtHead() 2) create new tail node 3) add it to the end 4) this.size++
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.size == 0) {
            addAtHead(val);
        }
        else {
            ListNode tailNode = new ListNode(val);
            this.tail.next = tailNode;
            this.tail = tailNode;
        }
        this.size++;
    }
    
    // Time: O(n)
    // Implementation: 1. If invalid, return 
    // 2. If head/ tail -> addAtHead()/addAtTail()
    // 3. 1) find previous node 2) create a new node and add it to previous node 3) add next node 4) this.size++
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            return;
        }
        else if (index == 0) {
            addAtHead(val);
            return;            
        }
        else if (index == this.size) {
            addAtTail(val);
            return;
        }
        ListNode pre = findNode(index - 1);
        ListNode next = pre.next;
        pre.next = new ListNode(val);
        pre.next.next = next;
        this.size++;
    }
    
    // Time: O(n)
    // Implementation: 1. If invalid, return 
    // 2. If head: 1) assign head 2) this.size--
    // 3. If tail: 1) find new tail 2) delete(next = null) 3) this.size--;
    // 4. 1) find previous node 2) assign previous.next node 3) this.size--
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        else if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        else if (index == this.size - 1) {
            this.tail = findNode(size - 2);
            this.tail.next = null;
            this.size--;
            return;
        }
        ListNode pre = findNode(index - 1);
        pre.next = pre.next.next;
        this.size--;
    }
    
    public ListNode findNode(int index) {
        ListNode cur = this.head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
