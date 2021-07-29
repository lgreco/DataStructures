# Final Exam, Summer 2021

## General instructions

Make sure that your code compiles. Uncompilable code will result to 0 points.

Your code must be clean, clear, and well documented with comments.

Bonus problems are available to everyone.
## Problem 1: Lists

Modify the class `FinalList` as follows, without changing the signatures of the methods.

* Complete the `boolean intersects` method to return true when two lists intersect and false otherwise. The list intersect if one list has a node with the same `content` as a node from the other list.

* Complete the `int countCommon` method to return the number of common nodes between two lists.

* (BONUS) Complete the `void displayCommmonNodes` method.

Before you begin coding, contemplate the design of your methods to determine which method you need to write first and whether you need any helper methods. Class `FinalList` includes a main method with rudimentary testing, so that you can verify your solutions.

## Problem 2: Trees

Modify the class `FinalTree` as follows, without changing the signatures of the provided methods or of the methods requested below.

* Complete `boolean isLeaf` in inner class `Node`.
* Modify inner class `Node` to include a pointer to the parent of the node. Consequently modify method `addNode` to assign a value to the parent pointer, upon successful insertion of a new node to the tree.
* (BONUS) Write a `boolean isLeft()` in inner class `Node` that returns `true` if the invoking node is the left child of its parent and false otherwise.

Class `FinalTree` includes a main method with rudimentary testing, so that you can verify your solutions (except the BONUS question).