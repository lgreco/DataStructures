# COMP 271 Midterm Summer 2021

This exam uses the following classes.

* [Node](Node.java): a class of nodes with pointers to their previous and next nodes. Thinkk of nodes as more generalized concepts of the train stations we used in our examples. The node objects described in `class Node` have a pointer to their next node and also a pointer to their previous node.

* [DoubleLinkedList](DoubleLinkedList.java): a class that assembles nodes in a bidirectional fashion.

* [Demo](Demo.java): a class that implements a DoubleLinkedList object.

<img src="DDL.png" width="33%" align="right"/>

The figure to the right shows a small double-linked list with three nodes: A, B, C. The **head** node is A. In a double-linked list, every node is required to be linked to a previous and a next node. There are two exceptions: the head node has no previous node. The rightmost node has no next node. You can think of the double-linked list as two single lists put together. One list moves from A to B to C. The other from C, to B, to A.

For the problems below, your code must be neat, clean, and thoroughly documented with comments. Neat and clean code means no superfluous or inconsistent spacing, suitably named variables, etc.

## Problem 1

Write a void method `display()` for class `DoubleLinkedList` that traverses the list from head to rightmost node and back to head, printing the contents of each node along the way. For the list of the figure above, the output will be:

`[A] [B] [C] [B] [A]`

Notice that the contents of each node appear inside a pair of square brackets.

## Problem 2

Write a method `removeNode` with the signature shown in the `DoubleLinkedList` class.