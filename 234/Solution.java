// Time complexity: O(n)
// Space complexity: O(1)
// Intuition: 1) reverse the last half of the linked list 
// 2) compare values of listnodes one by one in the first half and the second half
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode halfHead = findHalfHead(head);
        ListNode reversedHead = reverse(halfHead);
        ListNode i = head, j = reversedHead;
        while (j != null) {
            if (i.val != j.val) {
                return false;
            }
            i = i.next;
            j = j.next;
        }
        return true;
    }
    
    private ListNode findHalfHead(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
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
}
