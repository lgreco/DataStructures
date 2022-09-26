# Coding Studio for September 16, 2022

## A useful dresser

In this studio session, we'll improve the functionality of the Dresser class we developed earlier in the week. The cleaned up java class, called `Solutions_UsefulDresser.java`, is in this repository. Our objective is to "instruct" the class so that its objects can size each other up.

To appreciate how objects compare themselves to other objects of the same class, let's look at Strings. So far we'use the method `equals` to tell if two strings have the same content. Imagine a scenario, however, when we need to tell is a string is bigger than another string. What are the possible comparison outcomes between two strings `a` and `b`?

* `a` is bigger than `b`.
* `a` is equal to `b`.
* `a` is smaller than `b`.

Method `equals` covers the middle case, by returning an yes/no answer (true/false to be precise). But if `a.equals(b)` is false, it means that either `a` is bigger than `b` or `a` is smaller than `b`. How can we tell?

### Bigger or Smaller?

First, let's look at the ordering of objects. We'll consider Strings again, because we are so familiar with them. Is the string `"elephant"` bigger than the string `"snail"`? How can we possibly compare them?

* **In context:** the animal *elephant* is bigger than the animal *snail.*
* **By length:** the word elephant has more letters than the word snail.
* **Lexicographically:** the word elephant appears before the word snail in a dictionary.
* **Capriciously:** by creating our own measurement. For example, counting how many times the letter `'n'` appears in a word; here *elephant* and *snail* each have one `'n'`, therefore are equal.

Most -- well, all -- programming languages compare strings lexicographically. The word *elephant* is smaller than the word *snail.* In this example, the comparison is easy and can be established by looking at the first letter of each word: the letter `'e'` comes before `'s'`. This is also reflected in the ASCII values of these characters: `101` and `115` respectively.

What about `"foot"` and `"food"`? We compare the strings character by character until we find a pair of characters that are different. In this case, the pair `'t'` and `'d'` decides the comparison: *foot* is greater than *food*. In this comparisons, upper and lower case matter. For example, `"Dog"` is less than `"dog"` because the ASCII values for `'D'` and `'d'` are `68` and `100` respectively.

In Java, we cannot use the relational operators `<` and `>` between objects. These operators work only with primitive data types such as `int`, `double`, `char`, etc. (Neither can we use the equality operators `==` and `!=` between objects.) To compare two strings `a` and `b` in Java we use `a.equals(b)` instead of `a==b` and `!a.equals(b)` instead of `a!=b`. For relational comparison we use the `compareTo` method: `a.compareTo(b)`. The method returns an `int` value. If it is negative, it means that `a` is less than `b`. If it is positive, it means that `a` is greater than `b`. And if it is 0, it means that `a` is the same as `b`.

### Studio task

Write a `compareTo` method in the `UsefulDrawer` class. First, propose how two dressers are to be compared: what characteristics do you plan to use to establish a ranking system for dressers? Then write the method that, given two `Solutions_UsefulDresser` objects, say `dresserA` and `dresserB`, is called as

```java
dresserA.compareTo(dresserB)
```

and evaluates the relative rank of the two objects.
