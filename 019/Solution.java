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
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode quick = dummy;
        int count = 0;
        while (count <= n) {
            quick = quick.next;
            count++;
        }
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
