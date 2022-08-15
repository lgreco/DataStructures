/*

Delivers Programming Project 1, Chapter 7, from BJP/5e.

Objective: add two integer numbers that are too large to be represented  as  int
or long primitives.

The largest int number that Java can represent is 2,147,483,647.  If we add 1 to
it, we expect to get  2,147,483,648; however in  Java we'll  get -2,147,483,648.
That's  because  the  language  has  no  way  to represent a  number larger than
2,147,483,647.  Any arithmetic operations would result to larger numbers,  yield
spurious values. We call them overflow errors.

Overflow errors occur when we use long primitives as well. The largest value we
can represent with a long primitive is  9,223,372,036,854,775,807. That's a very
big number indeed, about nine million trillions.  But even adding one to it will
result to a negative value instead of 9,223,372,036,854,775,808.

 */

public class Chapter7_ProgrammingProject1 {

}  // class Chapter7_ProgrammingProject1
