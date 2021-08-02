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
### Validating your solution to problem 3

This problem asks you to demonstrate the logic and does not provide a testing framework for your method. In other words, unless you create a list with a loop, you cannot test the validity of your method. And that's ok, because all I want to see is the logic you plan to apply.

Now, if you want to experiment with looping lists, [I have published on GitHub the example we worked in class today](https://github.com/lgreco/DataStructures/tree/master/ChooChoo/Loopy/src).


## Support for the exam 

Given the short period for the exam, I may not be available to honor all requests for Zoom meetings. So let's take Zoom off the table for the exam. Instead, let's use Teams for urgent communications. 

For questions specific to the behavior (or misbehavior) of code you write, attach the `.java` file to your message. Screenshots or cut-and-paste may not always work. When possible, please use a line reference to help me find something (e.g., Line 78 is giving me an exception).


## Final Grades


Grading is completed. Exam scores and tentative final grades are posted on Sakai.Bonus problems are shown as a separate item on Sakai's grade book. I will be turning final grades to the registrar tomorrow.

If you notice a grade discrepancy, please let me know immediately. Grade discrepancies include missing grades or any concerns about your grade in the final exam.

With an **A** or **B** you can move into more advanced programming courses, if you wish so.

With a **C** you can pursue computing coursework, but you may have some catchup work to do. Work on the things that challenged you the most, to get comfortable with them.

If your final grade is a **D** and you want to pursue a computing major and a career in the field, I recommend that you discuss it with someone (an advisor, a mentor, etc). You can do anything you set your mind to, but you need some guidance how to make it work.



## Exam Solutions

Solutions for the final exam are available on GitHub. The comments in the code provide some narrative  about the technique used; I will be happy to answer any questions you may have.

### [Problem 1](https://github.com/lgreco/DataStructures/blob/master/Exams/SU21_Final/src/FinalList.java):

* [method `intersect`](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalList.java#L50);

* [method `countCommon`](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalList.java#L104);

* [method `displayCommmonNodes`](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalList.java#L139).

### [Problem 2](https://github.com/lgreco/DataStructures/blob/master/Exams/SU21_Final/src/FinalTree.java):

* [method `isLeaf`](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L24);

* adding a pointer to the parent of a node is done within the inner class `Node` ([line 10](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L10)) and operationalized in constructor `Node` (line [16](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L16)) and method `FinalTree.addNode` (lines [67](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L67) and [75](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L75)). One critical issue here is to assign a `parent` value to the newly *added* node. That newly added node is `current.left` (or `current.right`). So it is that node's parent that needs to be assigned as `current.left.parent = ...`.

* [method `isLeft`](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/Exams/SU21_Final/src/FinalTree.java#L29)

### Problem 3:

There are two solutions for your consideration. Both solutions implement a traversal of the linked list.

* A [simple (lazy) solution](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/ChooChoo/Loopy/src/LoopyList.java#L60) uses an array list to keep track of every node visited. If during its traversal the lazy method returns to a visited node, the linked list has a loop.

* There is also a [more algorithmic solution](https://github.com/lgreco/DataStructures/blob/a2efd96911f745f672ddbec874964cceb62b697f/ChooChoo/Loopy/src/LoopyList.java#L90): using two traversals at the same time, one faster than the other. If these two traversals intersect, the linked list has a loop. This method requires some justification as to why the two traversals eventually meet.

## Grading comments

Something I noticed across most of your code is the casual use of the `==` operator. This operator is safe to use between primitives but not so safe with objects, such as String, Node, etc. For objects, we use the equals() and compareTo() methods. Using `==` between objects may disqualify you in a technical interview. To illustrate this point, consider the following code (which you can copy and paste in JShell):

```
String a = new String("Leo");
String b = new String("Leo");
System.out.println(a==b); // Will it print true or false?
System.out.println(a.equals(b)); // True or false?
```

The `==` operator compares (memory) reference between two objects and answers a simple question: do they occupy the same address in memory, in other words are they the same object? Method `equals()` compares the contents of the object and determines if they are the same. The objects may be different, but the contents may be the same. For example, a person may have two residences: one in Chicago, one in Springfield. The addresses are different but the owner is the same -- that's what `equals` tells us.

## Course summary

In this course you looked at the fundamental mechanisms of data structures. You built data structures from scratch: how to build dynamic arrays (which are the basis for class `ArrayList`), linkable objects (the basis for classes `LinkedList` and `Tree`), first-in first-out processes (that define the interface `Queue`), mapping a binary tree to an array to build a priority queue, as well as hash-based structures.

As you explored the foundations for these structures, you learned a bit more about interfaces, inheritance, and polymorphism. You looked at sequential structures like linked list and trees, random access structures like arraylists, hybrids like hash-lists, and data structures that behave like mathematical sets, rejecting duplicate values like the binary search tree. And you developed a basic understanding of performance complexity, i.e., why some data structures are fast to create and slow to search or vice versa.

Just about every data structure you created from scratch, already exists in the *[Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)* (JCF). You can now use classes in the JCF, with an appreciation of what they do, how, and why.

## Reading recommendations

The last thing you may need after an intense course is more reading. Nevertheless, I'd like to recommend a few things to read and practice that are related to programming.

* Read as much as you can on [Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html). Start with the Oracle article, reread the relevant chapter in the *BJP* textbook, experiment with simple classes of your own design. Internalize the notion of *hierarchy* in an object-oriented language.

* Fire-up IntelliJ now and then and work on some code. Keep your IDE skills sharp. If you'd like to play with some code, take a look at the [car wash simulator](https://github.com/lgreco/DataStructures/tree/master/LeosCarWash/src) I wrote. Improve it! Change it. Find a bug. You're welcome to contact me with questions and suggestions.

* Explore another collection of data structures: [Google's Guava](https://github.com/google/guava#guava-google-core-libraries-for-java) libraries include extensions to the JCF worth knowning about.

* If you are developing a passion for programming, read *Effective Java* by Joshua Bloch. Used copies of the 2nd edition are available on Amazon for under $10. (The book is in its 3rd edition, but the 2nd is just fine).

## So long

Above all, have a great time off. It has been a privilege working with you this term. Looking forward to seeing you around campus in a few weeks.

