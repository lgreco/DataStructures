# COMP 271 Section 003 Midterm Fall 2020

## Hobbit names

Write a class with a public method that accepts a name as input and produces a Hobbit name as an output using the following rules:

* The Hobbit first name can be the name of a herb or a spice that begins with the first letter of the input name, e.g., Leo --> Lemongrass

* The Hobbit last name can be either the name of a favorite drink and the name of a baked good, or the name of an organ or body part (keep it decent!) and the name of a landform,<br>
 e.g., Armpit ( arm + pit ).
 
 Name this public method: `public String hobbitName(String name) {...}`.
 
 Even though your class must have a public method to produce and return the Hobbit name, it may contain any number of private methods that are necessary to accomplish the task. Users of your class should interact with it only through hobbitName. Everything else, including class fields, should be private.
 
 For a list of herbs, spices, body parts, and landforms, you may use (via URL objects) the following files, from <a href="https://github.com/lgreco/DataStructures/tree/master/Midterm%20F20/src">Leo's Github repository</a>:<br>
 * spices.txt
 * drinks.txt
 * baked_goods.txt
 * body_parts.txt
 * landforms.txt
 
Your class `hobbitName` should access the text files above over the web and not rely on local copies. (In other words, use the [URL class](https://docs.oracle.com/javase/7/docs/api/java/net/URL.html).)

Before you start, you should look over the data files, understand their contents and plan your code accordingly. 

It is up to you to decide how to handle missing data.

## Hello Chain

At the beginning of each online meeting, the instructor randomly greets a student whose camera is on. That student greets, also at random, another student whose camera is on. This chain continues until there is only one student with the camera on. That student says hello to the instructor, concluding the hello chain.

A lot of things can go wrong during the hello chain. For example a student's audio may be muffled, muted, or noisy. We can't tell who the student greeted, i.e., we don't know who's the next link in this hello chain. Likewise, the student who has been greeted may not have heard their name. Or a student greets, by mistake, a student whose camera is turned off, etc.

Design and write a `HelloChain` class to simulate the situation above. Your class must be based on a data structure of your choice (preferably one we covered in class). Don't pile everything in the `main` method.

## A LIFO "queue"

The `BBQ` implementation of the Q interface, was a FIFO (First-In, First-Out) queue. Using `BBQ` as a guide, write a class called QBB that implements the Q interface as a LIFO (Last-In, First Out) queue. In a FIFO queue elements are removed in the ordered in which they added. In a LIFO queue, elements are removed in the reverse order of arrival. Use a String array as the basis of your implementation.

