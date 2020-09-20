# Class Prerequisites

This class is a simple attempt at creating a data structure from first principles (i.e., using primitives, Strings, and no assistance from the _Java Collections Framework_). The class is based on a boolean product of sums, i.e., a _conjuctive normal form_ (CNF). CNFs are typically introduced in COMP 163 Discrete Structures ([Wikipedia article](https://en.wikipedia.org/wiki/Conjunctive_normal_form)).

Course prerequisites are indeed expressed in CNFs. For example, the prerequisites for COMP 271 are COMP 141 and (COMP 170 or COMP 215). The corresponding _maxterms_ are:<br>
(1) COMP 141<br>
(2) COMP 170 OR COMP 215

Now that we have an abstract model, namely CNFs, how do we implement them as a data structure? Let's imagine a two-dimensional array were each course occupies a column and a row. Using the example above, imagine this array's row corresponding to COMP 271:

```
                  [COMP          [COMP          [COMP
                   141]           170]           215]
              
[COMP 271]      COMP 141      COMP 215      COMP 170
```


The square brackets indicate row (or column) indices. The contents of the array indicate single or multi-valued maxterms. For example, the course in element `[COMP 271][COMP 141]` matches the value of the column index. We take that to mean a single-valued maxterm.

For the elements in columns `[COMP 271][COMP 170]` and `[COMP 271][COMP 215]` we notice that their values do not match their column indices. But we also notice that they point at each other. We take this cyclic reference to mean a multi-valued maxterm -- in this example a two-valued maxterm.

That's it! As long as we have a way to parse cyclic references to multi-valued maxterms, we can write prerequisites as CNFs. And as long as we have a way to register prerequisites in the two-dimensional array as CNFs, we are set!

