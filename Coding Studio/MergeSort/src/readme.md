# Coding Studio for September 23, 2022

## Split array into single-element arrays

This week we saw how two *sorted* arrays can be merged into a larger sorted array. The technique is summarized in the following code snippet. The code is a bit compact for brevity. Please don't treat it as a sample of good clean coding. Think of it more like pseudocode.  (Omitting, for example, curly braces from if blocks or loops when they have single-line scopes, is *not recommended.* )

```java
int[] merge(int[] a, int[] b) {
    int[] c = new int[a.lenght+b.length];
    int i = 0, j = 0, k = 0;  // cursor for arrays a, b, c
    while (i<a.length && j<b.length) {  // both arrays have elements to process
        if (a[i]<b[j])  // which of the leftmost elements form a,b is smallest
            c[k++] = a[i++];  // if a's leftmost, copy to c and advance a,c indices
        else
            c[k++] = b[j++];  // if b's leftmost, copy to c and advance b,c indices
    }  // loop ends when we go out of bounds in other array
    while (i<a.length)  // if b went out of bounds
        c[k++] = a[i++];  // copy a's remaining elements to c
    while (j<b.length)  // if a went out of bounds
        c[k++] = b[j++];  // copy b's remaining elements to c
    return c;
}
```

This technique is guaranteed to work as long as we provide it with *two* sorted arrays at the input.

During class, we also discussed how a single-element array is, by definition, sorted. Consider the following, terrible, code:

```java
int[] p = {14};  //  
int[] q = {8};   // These four single-element arrays
int[] r = {11};  // are sorted by definition.
int[] s = {1};   // 
int[] u = merge(p,q);  // will return [8,14]
int[] v = merge(r,s);  // will return [11,1]
int[] w = merge(u,v);  // will return [1,8,11,14]
```

We could have also skipped the middle steps and written even more terrible code:

```java
int[] w = merge(merge(p,q), merge(r,s));  // will return [1,8,11,14]
```

In principle, we could take an array like `[8,2,7,4,9,1,3,0]` and sort it like so:

```java
merge(merge(merge([8],[2]), merge([7],[4])), merge(merge([9],[1]), merge([3],[0])));
//                [8] [2]         [7] [4]                [9] [1]         [3] [0]
//                  \_/             \_/                    \_/             \_/
//                 [2,8]           [4,7]                  [1,9]           [0,3]
//                    \__[2,4,7,8]__/                        \__[0,1,3,9]__/
//                            \__________[0,1,2,3,4,7,8,9]_________/
```

The comments above show the progression of the merge calls from single-element arrays to larger arrays. It looks as if method `merge` calls itself, again and again. This  programming technique is called **recursion.** It is an always elegant, sometimes confusing, and usually memory-demanding way to solve problems.

Elegance, however, is not on today's menu!

## Your task

Design a method (let's call it `iterativeMergeSort`) that will accept an `int` array as input, partition it into 1-element segments, feed them to method `merge`, obtain the sorted output, replace it to the input array, then partition the array again into 2-element segments, feed them to `merge`, and so on.

Starter code is provided in this repository. Java class `SortingPractice` has two methods ready for you and one to complete, described below.

### Method `merge`

This method accepts two sorted arrays and merges them in an also sorted array. 

### Method `slice`

This method returns a slice of an array. For example, given the array `int[] x = {0,2,4,6,8,10,12}`, calling `slice(x,0,3)` will return the subarray from element `x[0]` and *up to but not including* `x[3]`. That wll be the subarray `[0,2,4]`.

### Your task: complete method `iterativeMergeSort`

See the comments in the starter code.