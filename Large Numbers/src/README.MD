# Very large integer representation
 
 Java's primitives for `int` and `long` types can accommodate most arithmetic needs, with ranges from -2,147,483,648 to 2,147,483,647 (for `int`) or -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (for `long`). That's plenty for many applications. There are, however, applications that require larger integers, e.g., numbers with 100s of digits. How can we represent them in a programming language?
 
Class `Gazillion` provides a simple mechanism for representing large integer numbers beyond the range of `long`. The class provides a constructor to map a string as a really long integer, and a method to add two such integers.

## Multiply
Complete this class by writing a method to multiply two very large integers:

`public void multiply(Gazillion gazillion){...}`.

You may want to brush up a bit on multiplication algorithms. There is an awesome multiplication algorithm written by A. Karatsuba (see PDF file in this folder). You do not need to implement this algorithm. The good old [grade school multiplication algorithm](https://en.wikipedia.org/wiki/Multiplication_algorithm#Long_multiplication) is all you need.

## Recursive multiplication

Develop method `RecursiveMultiplication` in class `Gazillion, based on our discussion about recursive multiplication. Start your work, assuming that the two objects to multiply have the same number of digits. Once you are satisfied with your method, make the following improvement: modify it to multiply two objects of with different number of digits.

## Minor improvement for method `Gazillion.toString`
Modify the method to print a Gazillion object more realistically. Right now the method returns a string with the underlying ArrayList, e.g.,

`"[3, 4, 5, 6, 1, 1]"`

for a Gazillion object with the number `345611`. Your improvement should print just numbers, using commas to separate 1000s, e.g.,

`"345,611"`