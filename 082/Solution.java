/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode slow = dummy.next;
        ListNode fast = dummy.next;
        while (fast != null) {
            while (fast.next != null && fast.next.val == slow.val) {
                fast = fast.next;
            }
            if (fast == slow) {
                tail.next = slow;
                tail = tail.next;
            }

            slow = fast.next;
            fast = fast.next;
        }
        
        tail.next = null;
        
        return dummy.next;
    }
}
