# Array shifts

In this simple lab, you will write a method to remove an element from an array and shift every element after it, one position to the left. For example, consider the array:

``` java
String[] a = {"A", "B", "C", "D", "E", "F"};
```

After applying your method:

```java
a = remove(a, 2);
```

array `a` should become:

```java
["A", "B", "D", "E", "F", null]
```

The method removed the element at position `a[2]` (that was string `"C"`), and moved every element after it one position to the left. The last position (`a[5]`) of the array becomes null, since there is nothing to its *right*.

Your method should work correctly with any String array. Verify that your method works properly by running it against the following `main()`.

```java
    public static void main(String[] args) {
        String[] test = {"A", "B", "C", "D", "E", "F"};
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(remove(test,222)));
        System.out.println(Arrays.toString(remove(test,-1222)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,0)));        
        System.out.println(Arrays.toString(remove(test,0)));
        System.out.println(Arrays.toString(remove(test,0)));
    }
```