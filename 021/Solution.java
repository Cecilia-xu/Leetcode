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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    cur.next = new ListNode(cur1.val);
                    cur = cur.next;
                    cur1 = cur1.next;
                }
                else {
                    cur.next = new ListNode(cur2.val);
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }
            else if (cur1 == null) {
                cur.next = new ListNode(cur2.val);
                cur = cur.next;
                cur2 = cur2.next;
            }
            else {
                cur.next = new ListNode(cur1.val);
                cur = cur.next;
                cur1 = cur1.next;
            }
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
