
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

