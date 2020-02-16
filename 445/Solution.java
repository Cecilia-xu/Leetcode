/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> nums1 = new Stack<>();
        Stack<Integer> nums2 = new Stack<>();
        while (l1 != null) {
            nums1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            nums2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode head = null;
        while (!nums1.isEmpty() || !nums2.isEmpty() || sum != 0) {
            sum += (nums1.isEmpty() ? 0: nums1.pop()) + (nums2.isEmpty() ? 0 : nums2.pop());
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            sum = sum / 10;
        }
        return head;
    }
}
