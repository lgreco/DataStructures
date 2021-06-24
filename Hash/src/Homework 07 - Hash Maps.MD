# Homework 07 - Hash maps

In this assignment, you need to work with class `HashFromScratch`. For problem 1 you may type your answer in the Sakai textbox (or attach a text file in Sakai). For problem 2, you are expected to provide a .java file as an attachment in Sakai.

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

In terms of Java, these pairs are linked-list objects of the following form:

```java
... class Airplane { // class name reflects example above
  private String tailNumber; // key
  private String model; // value
  private Airplane next; // next pair in list
  ...
  }
```
(The actual `HashMap` class in the Java Collections Framework uses generics that allow us to implement key-value pairs of any reference type. For our example here, we use Strings.)

Write your own class, called `AirplaneRegistry`, that provides a hash-based data structure for airplane records as illustrate above.

### `AirplaneRegistry` specification 1

The `AirplaneRegistry` should comprise the following fields: An array of `Airplane` objects (specified below); a count of objects stored in (an instance of) the class; a count of the underlying array elements utilized.

### `AirplaneRegistry` specification 2

Contains an *inner* class `Airplane` with the key-value pair shown in the example above. The class should be completed with the constructors for `(tailNumber, model)` and `(tailNumber, model, next)`.

### `AirplaneRegistry` specification 3

Develop your own hash function for the *key* field. Since we are no longer dealing with `int` content, we cannot use modulo arithmetic; at least not right away.

### `AirplaneRegistry` specification 4

An insert method that prevents duplicate tail numbers. You may want to consider a `boolean` reference type for this method, to indicate successful or failed insertion. (Hint: plan your `insert` method in a way that you can call it when, eventually, you have to resize and rehash the structure.) 

*Notice that we are not interested in resizing and rehashing the data structure, yet*.

#### Notes for lab session: from Hash Maps to Tree Maps; use of generics.