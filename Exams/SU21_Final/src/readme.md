# Final Exam, Summer 2021

## General instructions

Make sure that your code compiles. Uncompilable code will result to 0 points.

Your code must be clean, clear, and well documented with comments.

Bonus problems are available to everyone.

Please make sure that you upload the correct files (the first two problems require `.java` files; the last problem requires a `.txt` file).

To make things interesting: **you may use only one instance of ArrayList** and no other Java-supplied data structure.

## Problem 1: Lists

_For this problem, upload your `FinalList.java` file on Sakai._

Modify the class `FinalList` as follows, without changing the signatures of the methods.

* Complete the `boolean intersects` method to return true when two lists intersect and false otherwise. The lists intersect if one list has at least one LLNode with the same `content` as a LLNode from the other list.

* Complete the `int countCommon` method to return the number of common nodes between two lists.

* (BONUS) Complete the `void displayCommmonNodes` method.

Before you begin coding, contemplate the design of your methods to determine which method you need to write first and whether you need any helper methods. Class `FinalList` includes a main method with rudimentary testing, so that you can verify your solutions.

## Problem 2: Trees

_For this problem, upload your `FinalTree.java` file on Sakai._

Modify the class `FinalTree` as follows, without changing the signatures of the provided methods or of the methods requested below.

* Complete `boolean isLeaf` in inner class `LinkedList271`.
* Modify inner class `LinkedList271` to include a pointer to the parent of the LLNode. Consequently modify method `addNode` to assign a value to the parent pointer, upon successful insertion of a new LLNode to the tree.
* (BONUS) Write a `boolean isLeft()` in inner class `LinkedList271` that returns `true` if the invoking LLNode is the left child of its parent and false otherwise.

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
### Validating your solution to problem 3

This problem asks you to demonstrate the logic and does not provide a testing framework for your method. In other words, unless you create a list with a loop, you cannot test the validity of your method. And that's ok, because all I want to see is the logic you plan to apply.

Now, if you want to experiment with looping lists, [I have published on GitHub the example we worked in class today](https://github.com/lgreco/DataStructures/tree/master/ChooChoo/Loopy/src).


## Support for the exam 

Given the short period for the exam, I may not be available to honor all requests for Zoom meetings. So let's take Zoom off the table for the exam. Instead, let's use Teams for urgent communications. 

For questions specific to the behavior (or misbehavior) of code you write, attach the `.java` file to your message. Screenshots or cut-and-paste may not always work. When possible, please use a line reference to help me find something (e.g., Line 78 is giving me an exception).

