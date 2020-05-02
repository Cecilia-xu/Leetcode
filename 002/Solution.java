// Solution: Linked List
// Time complexity: O(n1 + n2)
// Space complexity: O(n1 + n2)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0; 
        while (cur1 != null || cur2 != null || carry == 1) {
            int val1 = (cur1 == null ? 0 : cur1.val);
            int val2 = (cur2 == null ? 0 : cur2.val);
            int val = val1 + val2 + carry;
            
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            
            cur = cur.next;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        
        cur.next = null;
        return dummy.next;
    }
}

// My previous solution: focus on how to deduplicate similar logic
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0;
        // optimize the condition of while loop (note: some changes on pointer moving statements)
        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + carry;
            if (val > 9) {
                carry = 1;
                val = val % 10;
            }
            else {
                carry = 0;
            }
            
            cur.next = new ListNode(val);
            
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        // similar logic
        while (cur2 != null) {
            int val = cur2.val + carry;
            if (val > 9) {
                val = val % 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            cur2 = cur2.next;
        }
        
        //similar logic
        while (cur1 != null) {
            int val = cur1.val + carry;
            if (val > 9) {
                val = val % 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            cur1 = cur1.next;
        }
        
        //similar logic
        if (carry == 1) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
