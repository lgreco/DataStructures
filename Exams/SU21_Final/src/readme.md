# Final Exam, Summer 2021

## General instructions

Make sure that your code compiles. Uncompilable code will result to 0 points.

Your code must be clean, clear, and well documented with comments.

Bonus problems are available to everyone.

Please make sure that you upload the correct files (the first two problems require `.java` files; the last problem requires a `.txt` file).

## Problem 1: Lists

_For this problem, upload your `FinalList.java` file on Sakai._

Modify the class `FinalList` as follows, without changing the signatures of the methods.

* Complete the `boolean intersects` method to return true when two lists intersect and false otherwise. The lists intersect if one list has at least one node with the same `content` as a node from the other list.

* Complete the `int countCommon` method to return the number of common nodes between two lists.

* (BONUS) Complete the `void displayCommmonNodes` method.

Before you begin coding, contemplate the design of your methods to determine which method you need to write first and whether you need any helper methods. Class `FinalList` includes a main method with rudimentary testing, so that you can verify your solutions.

## Problem 2: Trees

_For this problem, upload your `FinalTree.java` file on Sakai._

Modify the class `FinalTree` as follows, without changing the signatures of the provided methods or of the methods requested below.

* Complete `boolean isLeaf` in inner class `Node`.
* Modify inner class `Node` to include a pointer to the parent of the node. Consequently modify method `addNode` to assign a value to the parent pointer, upon successful insertion of a new node to the tree.
* (BONUS) Write a `boolean isLeft()` in inner class `Node` that returns `true` if the invoking node is the left child of its parent and false otherwise.

Class `FinalTree` includes a main method with rudimentary testing, so that you can verify your solutions (except the BONUS question).

## Problem 3: Looping lists

_For this problem, upload a TEXT file (`.txt` extension) with just the requested method. Do not upload a `.java` file for this problem. Your final name should be `hasLoop.txt`_

Consider a [simple link list](https://github.com/lgreco/DataStructures/tree/master/ChooChoo/SLL/src), similar to the one we studied in the `ChooChoo` class. Using classes `SimpleLinkedList` and `SimpleNode` as your starting point, write a method `boolean hasLoop()`, in class `SimpleLinkedList`, to tell if a linked list has a loop in it. Here're two examples of ... loopy lists:

`A --> B --> C --> D --> A` 

and

`A --> B --> C --> D --> E --> F --> G --> H --> C`

Your method `hasLoop()` should return `true` in both cases. 

Notice that the method's signature (no parameters) implies that it should be invoked by an object of its class, i.e.,

```java
SimpleLinkedList x = new SimpleLinkedList();
...
x.addNode("A");
x.addNode("B");
...
System.out.println(x.hasLoop()) // method invoked by an object of its class
```