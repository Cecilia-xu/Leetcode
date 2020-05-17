// Solution: Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode oddTail = dummyOdd;
        ListNode evenTail = dummyEven;
        ListNode cur = head;
        while (cur != null) {
            oddTail.next = cur;
            oddTail = oddTail.next;
            if (cur.next != null) {
                cur = cur.next;
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            cur = cur.next;
        }
        
        oddTail.next = dummyEven.next;
        evenTail.next = null;
        return dummyOdd.next;
    }
}
