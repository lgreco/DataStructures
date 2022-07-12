# Writing a simple interface
_Lab of July 12, 2022_

The objective of this lab is to create a class that utilizes a String array which accepts new data at select positions and allows the removal of data from a select position. These are the specifications for today's lab:

* Class name `XIFO`.
* Suggested name for the underlying array `values`.
* Default size of array: `4`.
* Customized constructor for any array size.
* Method to add an element at the first position (`[0]`) of `values`.
* Method to add an element at the *first available* position of `values`.
* Method to remove and return the first element of `values`.

In designing class `XIFO` to these specifications, you may have to consider if you need additional class variables, how to place data safely in the array, etc. To that end, you may have to develop tests that validate your assumptions for safe addition and removal of data from the array.