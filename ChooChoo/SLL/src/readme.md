# Lab of 21 JUL 2021

## Add a (linked) list to another list

Given two linked lists (using the classes `SimpleNode` and `SimpleLinkedList` provided here), how can you add one of them to the end of the other, without traversing both lists -- you are allowed to traverse only one of them.

Write a public void method with signature

```java
join(SimpleLinkList a, SimpleLinkedList b) {...}
```

to add list `b` after list `a`. Also determine if your method needs to be static or instance, i.e.,

```java
public static void join
```
or
```java
public void join
```
and justify your choice.

## Find the middle-ish LLNode

Write a method with signature

```java
public String getMiddleNodeContent(SimpleLinkedList a)
```

that returns the contents of the middleNode of a list. If the list has an even number of nodes, it is up to you to determine which of the two possible nodes will be the middle LLNode. You are allowed to traverse the list once.

## Compare two lists

Draft, but do not necessarily code, a method within `SimpleLinkedList` that compares a `SimpleLinkedList` object to another one, as follows:

```java
@Override
public int compareTo(SimpleLinkedList sll){}
```

The output of the method shall be a negative number if the instantiated object (.e., `this`) is smaller that `sll`; zero if the two objects are equal; and a positive number if `this` is bigger than `sll`.

It is up to you to decide and define the meaning of smaller, equal, and bigger in the context of `SimpleLinkedList` objects.

For example, the String class has its own compareTo method that works as follows.
```java
String a = "Leo";
String b = "Irakliotis";
int comparison = a.compareTo(b);
```
In the example above, `comparison` is a positive number indicating that `"Leo"` is greater that `"Irakliotis"`. That's because the `compareTo()` method in the String class makes an alphabetical comparison because the strings. But let's assume we want to compare strings based on length. We can override the `compareTo` method to work as follows.

```java
public class Gnirts extends String {
    // ...
    public int compareTo(String otherString) {
        return this.length() - otherString.length();
    }
}
```

Using the previous example,
```java
Gnirts a = "Leo";
Gnirts b = "Irakliotis";
int comparison = a.compareTo(b);
```
will give a negative comparison because essentially we are assigning that variable to the value:
```java
"Leo".lengh() - "Irakliotis".length()
```
which is -7. In this implementation of `compareTo`, the first string is smaller than the second. In other words, we overrode the String class' natural order of strings that was based on alphabetical order to a length-based order.

For the `SimpleLinkedList` you won't have to write an extending class with the new `compareTo` method. You can add the method straight into the `SimpleLinkedList` class. The main part of this exercise however is to decide, define, and justify your choice of a natural order for linked lists. To keep things interesting (and discourage you from the obvious choice) here's my implementation and, no you cannot use it.

```java
public class SimpleLinkedList {
    // ...
    @Override
    /**
     * Method that compares two SLL objects based on their number of nodes.
     *
     * @return a negative number if the argument SLL has more nodes than this object;
     *         zero if both lists have exactly the same number of nodes;
     *         a positive number if the argument SLL has fewer nodes than this object;
     */
    public int compareTo(SimpleLinkedList sll) {
        // return an int value
    } // method compareTo
    // ...
}
```