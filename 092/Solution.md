# My solution
> Time complexity: O(n) <br> Space complexity: O(1)
``` Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        int count = 1;
        ListNode pre = null;
        ListNode cur = head;
        while (count < m) {
            count ++;
            pre = cur;
            cur = cur.next;
        }
        ListNode reverseStart = pre;
        ListNode reverseEnd = cur;
        count ++;
        pre = cur;
        cur = cur.next;
        while (count <= n) {
            count ++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;            
        }
        if (reverseStart != null) {
            reverseStart.next = pre;           
            reverseEnd.next = cur;
            return head;
        }
        else {
            reverseEnd.next = cur;
            return pre;
        }

    }
}
```
