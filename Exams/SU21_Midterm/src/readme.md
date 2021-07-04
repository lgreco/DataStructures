# COMP 271 Midterm Summer 2021

## Problem 1

For this problem use the following classes:

* [Node](Node.java): a class of nodes with pointers to their previous and next nodes. Thinkk of nodes as more generalized concepts of the train stations we used in our examples. The node objects described in `class Node` have a pointer to their next node and also a pointer to their previous node.

* [DoubleLinkedList](DoubleLinkedList.java): a class that assembles together nodes in a bidirectional fashion.

* [Demo](Demo.java): a class that implements a DoubleLinkedList object.

<img src="DDL.png" width="33%" align="right"/>

The figure to the right shows a small double-linked list with three nodes: A, B, C. The **head** node is A. In a double-linked list, every node is required to be linked to a previous and a next node. There are two exceptions: the head node has no previous node. The rightmost node has no next node. You can think of the double-linked list as two single lists put together. One list moves from A to B to C. The other from C, to B, to A.