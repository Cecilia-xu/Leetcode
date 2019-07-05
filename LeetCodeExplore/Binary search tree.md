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
