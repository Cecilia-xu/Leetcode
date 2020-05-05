// Two pointers
// Figure out the definitions of two pointers: 
// 1) slow: find the node that is before the last n-th node we want to remove 
//    Why? remove means linked the node before n-th to the node after n-th node
// 2) fast: move to the end until null
// The difference between slow and fast should be n + 1
//
// Time complexity: O(n)
// Space complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if head is null
        if (head == null) {
            return head;
        }
        
        // create a dummy head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // initialize slow and quick pointers
        ListNode slow = dummy;
        ListNode quick = dummy;
        while (n > 0) {
            quick = quick.next;
            n--;
        }
        
        // traverse and find the previous node and next node of the target node
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
        }
        
        // remove(*slow the previoud node of our target node, so link it to slow.next.next NOT quick!! 
        // Because n can be 1 and quick can stop at our target node.)
        slow.next = slow.next.next;
        
        return dummy.next;
        
    }
}
