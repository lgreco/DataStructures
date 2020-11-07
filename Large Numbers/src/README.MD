# Very large integer representation
 
 Java's primitives for `int` and `long` types can accommodate most arithmetic needs, with ranges from -2,147,483,648 to 2,147,483,647 (for `int`) or -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (for `long`). That's plenty for most applications. There are applications that require really big integers, e.g., numbers with 100s of digits. How canw we represent them in a programming language?
 
Class `Gazillion` provides a simple mechanism for representing large integer numbers beyond the range of `long`. The class provides a constructor to map a string as a really long integer, and a method to add two such integers.

## Multiply
Complete this class by writing a method to multiply two very large integers, `public void multiply(Gazillion gazillion){...}`.

You may want to brush up a bit on multiplication algorithms. There is an awesome multiplication algorithm written by A. Karatsuba (see PDF file in this folder). You do not need to implement this algorithm. The good old [grade school multiplication algorithm](https://en.wikipedia.org/wiki/Multiplication_algorithm#Long_multiplication) is all you need.