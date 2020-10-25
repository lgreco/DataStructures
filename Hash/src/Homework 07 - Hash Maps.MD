# Homework 07 - Hash maps

For this assignment, you need to work with class `HashFromScratch`.

## Problem 1
First, observe that method `rehash` uses redundant code that repeats more or less what the `insert` method does. How would you modify these two methods to reduce code redundancy as much as possible? **Do not** rewrite the methods; just provide a short paragraph describing how you'd go about it.

## Problem 2
Hash maps so far are just a curiosity: an array of linked lists. We use a hash function to go left-right across the array, and we add new nodes to the list. Only instead of traversing the list to the last node, we add thew new item to the front -- speeding up insertions.

Now, let's make things a bit more interesting. Let's modify `HashFromScratch` to accommodate key-value pairs. A k-v pair is one of the most interesting and useful concepts in computing. It is a pair of two data items: the *key* item and the *value* item. The key is a unique identifier for the value we are storing. 

This is better illustrated with an example. The table below lists 4 key-value pairs. The key of the pair is the tail number of an aircraft. Tail numbers are the unique identifier of an airplane, akin to car license plates. The value of the pair is the model of the airplane. As you can see, keys are unique (no two airplanes may have the same tail number). Values can be duplicates. There are thousands of Archers and Skyhawks out there, each with a distinct, unique tail number.

| key    | value |
| ------ | -------------- |
| N4335K | Piper Archer   |
| N5399K | Cessna Skyhawk |
| N5266D | Piper Archer   |
| N21175 | Cessna Skyhawk |

In terms of Java, these pairs are linked list objects of the following form:

```java
... class Airplane { // class name reflects example above
  private String tailNumber; // key
  private String model; // value
  private Airplane next; // next pair in list
  }
```


