# Introduction to BST
A binary search tree (BST), a special form of a binary tree, satisfies the binary search property:
- The value in each node must be greater than (or equal to) any values stored in its left subtree.
- The value in each node must be less than (or equal to) any values stored in its right subtree.<br>
*It is noteworthy that inorder traversal in BST will be in ascending order. Therefore, the inorder traversal is the most frequent used traversal method of a BST.*
# Basic operation in BST
BSTs support three main operations: search, insertion and deletion. 
## Search
According to the property of BST, for each node:
- return the node if the target value is equal to the value of the node;
- continue searching in the left subtree if the target value is less than the value of the node;
- continue searching in the right subtree if the target value is larger than the value of the node.
## Insertion
- search the left or right subtrees according to the relation of the value of the node and the value of our target node;
- repeat STEP 1 until reaching an external node;
- add the new node as its left or right child depending on the relation of the value of the node and the value of our target node.
## Deletion
- If the target node has no child, we can simply remove the node.
- If the target node has one child, we can use its child to replace itself.
- If the target node has two children, replace the node with its in-order successor or predecessor node and delete that node.
