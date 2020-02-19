// Solution 1: merge sort (top --> down)
// Not the optimal solution 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        ListNode head2 = middle.next;
        middle.next = null;
        return mergeTwo(sortList(head), sortList(head2));
    }
    

    private ListNode mergeTwo(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                tail = tail.next;
                cur1 = cur1.next;
            }
            else {
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null || cur2 != null) {
            tail.next = (cur1 == null ? cur2 : cur1);
        }
        return dummy.next;
    }
}
