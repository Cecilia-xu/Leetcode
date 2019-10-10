# Linked list
## Singly linked list
![Linkedlist](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png)
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
2. insert ith
