# Solutions to Final Exam COMP 271 F21
*Leo Irakliotis* -- leo@cs.luc.edu

Coding solutions are available in this directory. Grading comments and a brief write up for problem 3 are below.

## Problem 1: loopy linked lists

This problem requires two pointers (cursors) to traverse the list at different speed. One cursor moves one node at a time, the other skips a node. If there is a loop, the two cursors will eventually coincide. Otherwise, one of them will reach the end of the list.

Points were deducted for the following omissions:

* Use of `.getNext() != null` instead of `.hasNext()`. Class `Node` provides a method to test if a node has a non-null pointer. Why not use it?
* Use of the `==` operator to compare the two cursors (or their content via `.getData()`). The Programmers Pact forbids the use of `==` between objects. Comparison must be via `equals`. Nevertheless, this was a case where the use of `==` may be justified and it was accepted if it was properly documented in comments.

# Problem 2: fast queues

This problem trades the time complexity that results from moving queue elements to the left everytime we remove something, with space complexity for storing points to the front and the back of the queue. Arrivals and departures from the queue are then processed in constant time, just by changing the values of the front and back pointers. 

You may have points deducted for the following omissions.

* Magic number in the default constructor (see posted solution here, how to avoid it);
* Default constructor making redundant field assignments -- ideally, you want the default constructor calling the basic constructor as shown in the posted solution;
* Class fields assigned outside constructors;
* Class fields declared but not used;
* Methods with break or multiple return statements;
* Lack of comments;
* Lack of javadoc;

## Problem 3: Gift giving

The most popular data structure proposed here was a linked list with a loop from its tail to its head (making use that everyone gets a gift). The second most popular structure was an array, following by a hashtable.

In any of these discussions, if you planned to use a random number generator to assign who-gives-to-whom, you should also included some thoughts about avoiding duplicate assignments. 

