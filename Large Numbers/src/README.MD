# Very large integer representation
 
 Java's primitives for `int` and `long` types can accommodate most arithmetic needs, with ranges from -2,147,483,648 to 2,147,483,647 (for `int`) or -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (for `long`). That's plenty for many applications. There are, however, applications that require larger integers, e.g., numbers with 100s of digits. How can we represent them in a programming language?
 
Class `Gazillion` provides a simple mechanism for representing large integer numbers beyond the range of `long`. The class provides a constructor to map a string as a really long integer, and a method to add two such integers.

## Multiply -- this is now Assignment 08
Complete this class by writing a method to multiply two very large integers:


`public void multiply(Gazillion gazillion){...}`.

You may want to brush up a bit on multiplication algorithms. There is an awesome multiplication algorithm written by A. Karatsuba (see PDF file in this folder). You do not need to implement this algorithm. The good old [grade school multiplication algorithm](https://en.wikipedia.org/wiki/Multiplication_algorithm#Long_multiplication) is all you need.

## Recursive multiplication -- this is now Assignment 09

Develop method `RecursiveMultiplication` in class `Gazillion, based on our discussion about recursive multiplication. Start your work, assuming that the two objects to multiply have the same number of digits. Once you are satisfied with your method, make the following improvement: modify it to multiply two objects of with different number of digits.

## Minor improvement for method `Gazillion.toString` -- -- this is now Assignment 09
Modify the method to print a Gazillion object more realistically. Right now the method returns a string with the underlying ArrayList, e.g.,

`"[3, 4, 5, 6, 1, 1]"`

for a Gazillion object with the number `345611`. Your improvement should print just numbers, using commas to separate 1000s, e.g.,

`"345,611"`

## Karatsuba algorithm 

The recursive algorithm we reviewed in class, takes two large numbers, x and y, each with N digits, cuts them in half, and works with those halves.

```
 Input: integers x, y; each N digits long; N is power of 2
Output: product of x, y

int recursiveMultiplication(int x, int x):
  int N = (int) Math.log10(x) + 1; // number of digits in x (and y)
  if ( N == 1 ):
    return x*y;
  else:
    int powerOfTen = (int) Math.pow(10,N/2);
    a = x / powerOfTen; // left half of x
    b = x - a*powerTen; // right half of x
    c = y / powerOfTen; // left half of y
    d = y - c*powerOfTen; // right half of y
    // recursive calls
    int ac = recursiveMultiplication(a,c);
    int ad = recursiveMultiplication(a,d);
    int bc = recursiveMultiplication(b,c);
    int bd = recursiveMultiplication(b,d);
    return powerOfTen*powerOfTen*ac + powerOfTen*(ad+bc) + bd 
```

Karatsuba's algorithm achieves the same results but with only 3 instead of 4 recursive calls. Anatoly Karatsuba observed that once you have the quantities `ac` and `bd` calculated, you need one more recursive call to obtain the value of sum `ad+bc`. Specifically, he looked if there is a quantity `pq` such that: 
```
ad + bc = pq - ac - bd
-------   --   --   --
      |    |    |    |
      |    |    |    +---> already computed
      |    |    +--------> already computed too
      |    +-------------> unknown quantity
      +------------------> two recursive calls, one for ad
                           and one for bc, that we would like
                           to substitute with one if we can!
```
which can be obtained with only one more recursive multiplication. From the equation above, we can solve for `pq`:

```
pq = a*d + b*c + a*c + b*d // writing variables as products 
   = a*(c+d) + b*(c+d)     // for clarity, to illustrate the
   = (a+b)*(c+d)           // factoring leading to one multiplication!
```
which is the product of two sums, and thus needs one recursive multiplication call:

```
    int p = a + b;
    int q = c + d;
    ...
    int pq = recursiveMultiplication(p,q);
```

We can modify our previous algorithm by replacing the two recursive calls for `ad` and `bc` with the one for `pq` and return the following value:

```
    return powerOfTen*powerOfTen*ac + powerOfTen*(pq-ac-bd) + bd 
```