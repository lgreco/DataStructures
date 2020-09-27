# COMP 271 Section 003 Midterm Fall 2020

## Hobbit names

Write a class with a public method that accepts a name as input and produces a Hobbit name as an output using the following rules:

* The Hobbit first name can be the name of a herb or a spice that begins with the first letter of the input name, e.g., Leo --> Lemongrass

* The Hobbit last name can be either the name of a favorite drink and the name of a baked good, or the name of an organ or body part (keep it decent!) and the name of a landform,<br>
 e.g., Armpit ( arm + pit ).
 
 Name this public method: `public String hobbitName(String name) {...}`.
 
 Even though your class must have a public method to produce and return the Hobbit name it may contain any number of private methods that are necessary to accomplish the task. Users of your class should interact with it only through hobbitName. Everything else, including class fields, should be private.
 
 For a list of herbs, spices, body parts, and landforms, you may use (via URL objects) the following files, from <a href="https://github.com/lgreco/DataStructures/tree/master/Midterm%20F20/src">Leo's Github repository</a>:<br>
 * spices.txt
 * drinks.txt
 * baked_goods.txt
 * body_parts.txt
 * landforms.txt
 
Your class `hobbitName` should access the text files above over the web and not rely on local copies.

Before you start, you should look over the data files, understand their contents and plan your code accordingly. 