# My solution 1: Iteration
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        
        return pre;
    }
}
```
Note:
1. After iteration, the curr pointer will point to the last node, which is null. However, the head of the reversed linked list is not null. Therefore, we should return pre.
# Solution 2: Recursion
> Time complexity: O(n) <br> Space complexity: O(n)
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode reverseHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reverseHead;
        }
    }
}
```
Note:
1. How to write recursion: 
- List the last simplest case and what it will return
- List other cases which should be composed of the similar method with different input and other necessary operations
2. Space complexity: When using recursion, the previous head.next will be kept until the recursion reached n depth.
