# Linked list
## Singly linked list
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png" width = 50%></img>
### 1. Node Structure
``` Java
public class SinglyListNode {
  int val;
  SinglyListNode next;
  SinglyListNode(int x) {
    val = x;
  }
}
```
### 2. Operations
1. access ith element:
- traverse from the head node one by one
> time complexity: O(n)
2. add an element:
1) Not head node/end node
- initialize a new node cur with given value:<br>
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163224.png" width = 50%></img>
- link cur.next to the next node next:<br>
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png" width = 50%></img>
- link pre.next to cur:<br>
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png" width = 50%></img>
> Time complexity: O(1)
2) Head node
- initialize a new node cur
- link the new node to our original head node head
- assign cur to head
3) End node
- initialize a new node cur
- link the current end node to the new node
- link the new node to null
3. delete an node:
- find cur's previous node prev and its next node next:<br>
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/27/screen-shot-2018-04-26-at-203558.png" width = 50%></img>
- link prev to cur's next node next<br>
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-26-at-203640.png" width = 50%></img>
> Time complexity: O(N): This is because we need to find out prev and next. Even though it is easy to find next, we need to traverse the linked list from the head node to find out prev.<br>
Space complexity: O(1): This is because we only need constant space to store our pointers.
