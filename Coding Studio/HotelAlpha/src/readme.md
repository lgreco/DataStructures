# Coding Studio for October 28, 2022

## Moving guests into their rooms faster

At the Weird Alphabetical Hotel, guests are assigned to rooms based on their names. Their room number is determined by their name's initial letter, using the following highly advanced formula:

``room number = ASCII value of initial letter % N``

Here, ``N`` is the number of hotel rooms and ``%`` is the modulo operator.

This ingenious assignment is bad for business. Consider a hotel with ``N=100`` rooms and no guests. The first guest to arrival is *Galadriel.* The first initial of her name is ``G``, its ASCII value is ``71``, and ``71%100=71``. So, she is assigned to room 71.

The second guest to arrive is *Gimli.* He should be assigned to room 71. But the room was already given to another guest. Do we really want to turn away a guest when our hotel has 99 empty rooms, just because the *ideal* room is not available?

So we decided to handle *collisions,* i.e., two (or more) guests matched to the same room. Galadrier, the first guest, will keep room 71. And Gimli, the second guest, will be assigned to the room 71+1, if it's available. If room 72 is not available we'll try 71+1+1. And if that is not available either, then we can turn the guest away.

The policy, and technique, to consider nearby rooms is called probing. The probing length is the number of rooms to consider -- in this example 3, including the ideal room.

In class ``WeirdAlphaHotel``, probing is implemented in lines 98-110. The code is repetitive, therefore redundant. Repetitive code is not usually a good thing because it introduces multiple points of maintenance.

Repetitive code can be avoided with loops. For example, when we see code like the following:

```java
System.out.println(128);
System.out.println(256);
System.out.println(512);
System.out.println(1024);
System.out.println(2048);
System.out.println(4096);
```

we tend to replace it with a for-loop

```java
for (int n=7; n<13; n++) {
    System.out.println((int) Math.pow(2,n))
}
```

or a while-loop:

```java
int value = 128
while (value < 8192) {
    System.out.println(value);
    value = value*2;
}
```

## Your task

* Identify the repetitive code. 
* What are the repeating statements? 
* How many times they repeat?
* Are the repetitions connected to a property of the code, i.e., a local or a class variable?
* Replace the repeating code with an appropriate loop that delivers the same functionality.