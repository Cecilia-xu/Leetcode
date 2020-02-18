// Solution 1: Min heap
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            tail.next = node;
            tail = tail.next;
        }
        return dummy.next;
    }
}
// Solution 2: divide and conquer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        else if (left == right) {
            return lists[left];
        }
        else if (left + 1 == right) {
            return mergeTwoLists(lists[left], lists[right]);
        }
        else {
            int mid = left + (right - left) / 2;
            return mergeTwoLists(mergeHelper(lists, left, mid), mergeHelper(lists, mid + 1, right));
        }
    }
        
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
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
