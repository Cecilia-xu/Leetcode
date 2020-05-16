// Solution: linked list rotation
// Time complexity: O(n)
// Space complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // DO not forget for all linked list questions！ Check null head first!
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // get the length and the oldTail of the list
        ListNode oldTail = dummy;
        int len = 0;
        while (oldTail.next != null) {
            len++;
            oldTail = oldTail.next;
        }
        
        // find the net count of shifts we need to rotate
        k = k % len;
        
        // if the net count of rotate is 0, return head directly
        if (k == 0) {
            return head;
        }
        
        // if not, find the newTail after rotation
        ListNode newTail = dummy;
        for (int i = 0; i < len - k; i++) {
            newTail = newTail.next;
        }
        
        // rotate
        dummy.next = newTail.next; // newTail.next is the new head after rotation
        oldTail.next = head; // oldTail.next is the tail of rotation part
        newTail.next = null; 
        
        return dummy.next;
    }
    
}
