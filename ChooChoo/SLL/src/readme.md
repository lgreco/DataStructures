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

## Find the middle-ish node

Write a method with signature

```java
public String getMiddleNodeContent(SimpleLinkedList a)
```

that returns the contents of the middleNode of a list. If the list has an even number of nodes, it is up to you to determine which of the two possible nodes will be the middle node. You are allowed to traverse the list once.