/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode headPartial = reverseList(middle.next);
        middle.next = null;
        ListNode tail1 = head;
        ListNode tail2 = headPartial;
        while (tail1 != null && tail2 != null) {
            ListNode next1 = tail1.next;
            ListNode next2 = tail2.next;
            tail1.next = tail2;
            tail1 = tail1.next;
            tail1.next = next1;
            tail1 = tail1.next;
            tail2 = next2;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public ListNode findMiddle(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
