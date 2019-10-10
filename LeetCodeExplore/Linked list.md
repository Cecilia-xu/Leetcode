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
- time complexity: O(n)
2. insert ith element:
- initialize a new node cur with given value:
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163224.png" width = 50%></img>
- link cur.next to the next node next:
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png" width = 50%></img>
- link pre.next to cur
<img src = "https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png" width = 50%></img>
