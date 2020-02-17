/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = smallDummy;
        ListNode cur2 = largeDummy;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = new ListNode(cur.val);
                cur1 = cur1.next;
            }
            else {
                cur2.next = new ListNode(cur.val);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur2.next = null;
        cur1.next = largeDummy.next;
        return smallDummy.next;
    }
}
