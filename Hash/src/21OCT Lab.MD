# Lab session of 21 October 2020

Given the `MagicDoubling` class, develop a method that will allow the class's underlying array to resize, everytime it exceeds a certain saturation level. We define *saturation level* as the fraction: occupied/capacity, where `occupied` is the number of array elements presently occupied and `capacity` is the length of the array.
  
Resizing the array may appear easy -- and to a great extent it is. But, resizing the array by itself is not enough. Consider the following example, with an underlying array initially set to `capacity=4`, for which we use the integer remainder as the hash function:
   
   index to store value at = value % capacity
  
```text
  [ 0 ]   [ 1 ]   [ 2 ]   [ 3 ]
+-------+-------+-------+-------+
|    4  |    9  |       |    7  |
+-------+-------+-------+-------+
     8       5              14               
    32                      21
                            35
```

We decide to resize the underlying array every time the saturation reaches 75%, and in the example above, it has. We also decide to resize by adding one more element to the underlying array (rather silly choice but illustrative enough). As you can see below, adding just extra space to the underlying array leads to a confusing situation.

```text
  [ 0 ]   [ 1 ]   [ 2 ]   [ 3 ]   [ 4 ]  
+-------+-------+-------+-------+-------+
|    4  |    9  |       |    7  |       |
+-------+-------+-------+-------+-------+
     8       5              14               
    32                      21
                            35
```

The new `capacity` is now 5. This value redefines our hash function. When we try to access value `4` in the array
, the hash function tells us to look at `4%capacity`, which is position `[4]`. That position contains an empty list; no 4!

Clearly, resizing is not enough. After resizing we need to rehash every element in the array.

Write a method called **rehash** that will return a new array, resized to a length of your choice and re-hashed accordingly. The resizing factor can be determined as a `final static int` field in the class). You will also need to update the class' insertion method to track the saturation level and resize when necessary. The saturation level should be defined also as a `static final` field in the class.
  
Build the **rehash** method in such a way that will update a class field with the number of steps it took to resize  and rehash the underlying array. Use this field (let's call it `steps`) to keep track of how many operations are required to rehash an array from one length to another, when it contains a given number of elements (measured by field `size`). Use your judgement about what operations to count.