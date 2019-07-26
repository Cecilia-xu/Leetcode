# Intuition
- Change the sequence of each node and its next node
# Algorithm
Problem: when break the original link, we might lose the information of the next node -> Store next node in advance
# Pseudocode
```Java
Input: ListNode head
Output: ListNode

// Two pointers
// Note: After reversing, the first node will point to null. So we have to intialize pre to null.
ListNode pre = null, cur = head;
// Scan nodes of the linked list one by one
while (cur != null) :
  // Store next list node
  ListNode next = head.next
  cur.next = pre
  pre = cur
  cur = next
// Since we make cur = null, therefore the last node is pre now.
return pre;
```
# Complexity
- Time complexity: O(n)
- Space complexity: O(1)
