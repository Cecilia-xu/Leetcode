// Iteration
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while (tail.next != null && tail.next.next != null) {
            ListNode bef = tail.next;
            ListNode aft = tail.next.next;
            bef.next = aft.next;
            aft.next = bef;
            tail.next = aft;
            tail = bef;
        }
        return dummy.next;
    }
}

// Recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head.next.next;
        ListNode newHead = reversePairs(head);
        head.next = swapPairs(nextHead);
        return newHead;
    }
    
    public ListNode reversePairs(ListNode head) {
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return next;
    }
}
