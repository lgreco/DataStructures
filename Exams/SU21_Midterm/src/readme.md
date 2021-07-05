# COMP 271 Midterm Summer 2021

The exam comes in two flavors:

* **Peach flavor:** Problems 1 and 2, or
* **apricot flavor:** Problems 1, 3, 4, and 5.

You only need to complete one of the two flavors.
  
This exam uses the following classes.

* [Node](Node.java): a class of nodes with pointers to their previous and next nodes. Think of nodes as a form of the train stations we used in our previous examples. The objects described by class `Node` have a pointer to their next node and also a pointer to their previous node.

* [DoubleLinkedList](DoubleLinkedList.java): a class that assembles nodes in a bidirectional fashion.

* [Demo](Demo.java): a class that implements a DoubleLinkedList object.

<img src="images/DLL.png" width="33%" align="right"/>

The figure to the right shows a small double-linked list with three nodes: A, B, C. (You may click on the image for a larger rendering). The **head** node is A. In a double-linked list, every node is required to be linked to a previous and a next node. There are two exceptions: the head node has no previous node. The rightmost node has no next node. You can think of the double-linked list as two single lists put together. One list moves from A to B to C. The other from C, to B, to A.

For the problems below, your code must be neat, clean, and thoroughly documented with comments. Neat and clean code means no superfluous or inconsistent spacing, suitably named variables, etc.

## Problem 1 (3 points)

Write a void method `display()` for class `DoubleLinkedList` that traverses the list from head to rightmost node and back to head, printing the contents of each node along the way. For the list of the figure above, the output will be:

`[A] [B] [C] [B] [A]`

Notice that the contents of each node appear inside a pair of square brackets.

## Problem 2 (6 points)

Write a method `removeNode` with the signature shown in the `DoubleLinkedList` class. The method removes a Node from the list and returns it to the calling part of the program, e.g.

`Node gone = removeNode("B");
`

finds (if there is one) the node with content "B", removes it from the list, adn returns it as node `gone` for us to inspect it or ignore it. If the list, before the removal, had nodes `[A] [B] [C]`, after the removal has `[A] [C]`. And when traversed with the `display` method from the previous problem, the output will be

`[A] [C] [A]`

Removing a node is a bit complicated, so the following two hints will come handy.

### Hint 1

Before start coding, solve the problem on paper, using circles to represent nodes and arrows to represent points. Come up with a step-by-step description of your technique. For example, do not just state:

`find the node with content "B"`

Instead, describe how:

```{java, tidy=FALSE, eval=FALSE, highlight=FALSE }

begin from the head node and examine every node:
  if node content string we are looking for:
    node found
  else
    no such node exist
```
For every simple step that you identify, look at `class Node` to find if it provides a method that accomplishes the task. For example, if one of your simple steps is:

`make node with content "B" previous to node with "C"`

the corresponding method is `Node.setPrevious` and the actual statement would look like:

```java
nodeWithB.setPrevious(nodeWithC);
```
assuming `nodeWithB` and `nodeWithC` are `Node` objects that have been already assigned values, e.g.,
```java
Node nodeWithB = new Node("B");
Node nodeWithC = new Node("C");
```

**To summarize this hint:** conceptualize the process using simple design and study class `Node` very carefully!

### Hint 2

Consider a single-linked list, much like the one we studied in class `Route` and the implementation of the _Lincoln Service_ train line. In general, a single-linked list is a chain of nodes. Each node has a `next` pointer.

<p align="center"><img src="images/SLL.png" width="66%"></p>

The figure above shows a simple single-linked list. We would like to remove the node with content `"C"`. How can we accomplish this?

First, let's try to show the removal, pictorially:

<p align="center"><img src="images/SLL-removal.png" width="66%"></p>

That's pretty easy: we take the `next` pointer from the node before `"C"` and we direct it to the node after `"C"`. For a good measure, we also take the `next` pointer from `"C"` and we direct it to `null`. How can we do this in Java? Well, that's something for the final exam; removal from a single-linked list is not as easy as dealing with a double-linked node! But suffice to say this: if we have a way to tell which node is before `"C"`, we can take that node's `next` pointer and move it from `"C"` to `"D"`.

## Problem 3 (1 points)

Write a method

```java
public int countNodes() {...}
```

that returns a non-negative number with the number of nodes in a `DoubleLinkedList` object.

## Problem 4 (3 points)

Write a method 
```java
public String toString() {...}
```
that returns the contents of a `DoubleLinkedList` in reverse order by traversing the list only once from the `head` node to the rightmost node. (Hint: pretend that nodes do not have a `previous` pointer).

## Problem 5 (2 points)

Write a variation of the `add` method in `DoubleLinkedList` with signature

```java
public boolean addUnique(String s)
```

that adds a new node at the right end of the list only if there is no other node already in the list with the same content (`String s`).