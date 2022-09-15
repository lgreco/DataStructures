# Coding Studio for September 16, 2022

## A useful dresser

In this studio session, we'll improve the functionality of the Dresser class we developed earlier in the week. The cleaned up java class, called `UsefulDresser.java`, is in this repository. Our objective is to "instruct" the class so that its objects can size each other up.

To appreciate how objects compare themselves to other objects of the same class, let's look at Strings. So far we'use the method `equals` to tell if two strings have the same content. Imagine a scenario, however, when we need to tell is a string is bigger than another string. What are the possible comparison outcomes between two strings `a` and `b`?

* `a` is bigger than `b`.
* `a` is equal to `b`.
* `a` is smaller than `b`.

Method `equals` covers the middle case, by returning an yes/no answer (true/false to be precise). But if `a.equals(b)` is false, it means that either `a` is bigger than `b` or `a` is smaller than `b`. How can we tell?

