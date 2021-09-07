import java.util.Scanner;

/**
 * Solutions for the "Practice and recap" set of exercises.
 *
 * The methods below appear in the order listed in the problem set. If a problem
 * asks for a class, instead of a method, a commend block provides instructions
 * where to find the corresponding file.
 */
public class CSbS_Practice_And_Recap {

    /*
    Write a console program in a class named ComputeSumOfDigits that prompts the
    user to type an integer and computes the sum of the digits of that integer.
    You may assume that the user types a non-negative integer.
     */
    static void computeSumOfDigits() {
        Scanner s = new Scanner(System.in);
        System.out.print("Type an integer: ");
        int n = s.nextInt();
        int sum = 0;
        while (n>0) {
            sum += n % 10;
            n = n/10;
        }
        System.out.println("Digit sum is " + sum);
    } //  computeSumOfDigits


    /*
    Write a method named containsTwice that accepts a string and a character as
    parameters and returns true if that character occurs two or more times in the
    string. For example, the call of containsTwice("hello", 'l') should return true
    because there are two 'l' characters in that string.
     */
    static boolean containsTwice(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count>1;
    } // containsTwice


    /*
    Write a method named findRange that accepts an array of integers as a parameter
    and returns the range of values contained in the array, which is equal to one more
    than the difference between its largest and smallest element. For example, if the
    largest element is 17 and the smallest is 6, the range is 12. If the largest and
    smallest values are the same, the range is 1.

    Constraints: You may assume that the array contains at least one element (that its
    length is at least 1). You should not modify the contents of the array.
     */
    static int findRange(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];
        }
        return 1 + max - min;
    } // findRange


    /*
    Write a method named countDuplicates that accepts an array of integers as a
    parameter and that returns the number of duplicate values in the array.
    A duplicate value is a value that also occurs earlier in the array. For example,
    if an array named a contains [1, 4, 2, 4, 7, 1, 1, 9, 2, 3, 4, 1], then the
    call of countDuplicates(a) should return 6 because there are three duplicates
    of the value 1, one duplicate of the value 2, and two duplicates of the value 4.

    Constraints: The array could be empty or could contain only a single element;
    in such cases, your method should return 0. Do not modify the contents of the array.
     */
    static int countDuplicates(int[] a) {
        int count = 0;
        boolean[] visited = new boolean[a.length]; // Remember which elements we visit
        if (a.length > 1 ) {
            for (int i = 0; i < a.length; i++) {
                if (!visited[i]) { // Have we been here before?
                    visited[i] = true; // Mark as visited
                    for (int j = i+1; j < a.length; j++) {
                        if (!visited[j] && a[i] == a[j]) {
                            visited[j] = true; // Mark everything == as visited as well
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    } // countDuplicates


    /* The solution for the problem "Circle" can be found in the file
       Circle.java
       in the same folder as the present file. */


    /*
    Write a method named decimalToBinary that accepts an integer as a parameter and
    returns an integer whose digits look like that number's representation in binary (base-2).
    For example, the call of decimalToBinary(43) should return 101011.

    Constraints: Do not use a string in your solution. Also do not use any built-in base
    conversion methods like Integer.toString.
     */
    static int decimalToBinary(int n) {
        int bin = 0;
        int power = 1;
        while (n>1) {
            bin += power * (n%2);
            power *= 10;
            n = n/2;
        }
        bin += power * n;
        return bin;
    } // decimalToBinary


    /*
    Write a method named showTwos that shows the factors of 2 in a given integer.
     */
    static void showTwos(int n) {
        System.out.printf("%d = ", n);
        if ( n%2 == 0 ) {
            while (n%2 == 0) {
                System.out.print("2 * ");
                n = n/2;
            }
        }
        System.out.printf("%d", n);
    } // showTwos


    /*
    Write a method named factorial that accepts an integer n as a parameter and returns
    the factorial of n, or n!. A factorial of an integer is defined as the product of
    all integers from 1 through that integer inclusive. For example, the call of
    factorial(4) should return 1 * 2 * 3 * 4, or 24. The factorial of 0 and 1 are defined
    to be 1. You may assume that the value passed is non-negative and that its factorial
    can fit in the range of type int.
     */
    static int factorial(int n) {
        int product = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                product = product * i;
            }
        }
        return product;
    } // factorial


    /*
    Write a method named countUnique that accepts an array of integers as a parameter
    and returns a count of the number of unique values that occur in the array. If the
    array contains multiple occurrences of the same element value, only one of those occurrences
    should count toward your total. For example, if an array named numbers stores
    {7, 7, 2, 2, 1, 2, 2, 7}, the call of countUnique(numbers) should return 3 because
    there are 3 unique values: 7, 2, and 1.

    Constraints: In solving this problem, do not create any other data structures such as
    arrays, strings, etc., though you may create as many simple variables (e.g. int, double)
    as you like. Do not modify the array passed to your method as the parameter, such as by
    sorting or rearranging its element values.
     */
    static int countUnique(int[] a) {
        int unique = 0;
        for (int i = 0; i < a.length; i++) { // For every element in array ...
            boolean duplicate = false; // .. assume it has no duplicate ...
            for (int j = i+1; j < a.length; j++) { // .. and compare it with ...
                if (a[i] == a[j]) // ... every other element to find if it actually ...
                    duplicate = true; // .. has a duplicate
            }
            if (!duplicate) // If no duplicate found ...
                unique++; // .. increase count of unique by one.
        }
        return unique;
    } // countUnique


    /*
    Write a method named wordCount that accepts a string as its parameter and returns the
    number of words in the string. A word is a sequence of one or more non-space characters
    (any character other than ' '). For example, the call of wordCount("hello, how are you?")
    should return 4.

    Constraints: Do not use a Scanner to help you solve this problem. Do not use any data
    structures such as arrays to help you solve this problem. Do not use the String method
    split on this problem. But you can declare as many simple variables like int, char, etc.
    as you like. Declaring String variables is also fine.
     */
    static int wordCount(String s) {
        char SPACE = ' ';
        int count = 0;
        if ( s.length() > 0 ) {
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == SPACE) {
                    i++;
                } else {
                    count++;
                    while (i < s.length() && s.charAt(i) != SPACE)
                        i++;
                }

            }
        }
        return count;
    }  // wordCount


    /*
    Write a method named isPalindrome that accepts a string parameter and returns
    true if that string is a palindrome, or false if it is not a palindrome.

    For this problem, a palindrome is defined as a string that contains exactly the
    same sequence of characters forwards as backwards, case-insensitively. For example,
    "madam" or "racecar" are palindromes, so the call of isPalindrome("racecar") would
    return true. Spaces, punctuation, and any other characters should be treated the same
    as letters; so a multi-word string such as "dog god" could be a palindrome, as could
    a gibberish string such as "123 $$ 321". The empty string and all one-character strings
    are palindromes by our definition. Your code should ignore case, so a string like "Madam"
    or "RACEcar" would also count as palindromes.
     */
    static boolean isPalindrome(String s) {
        boolean pali = true;
        s = s.toLowerCase();
        for (int i = 0; i < s.length()/2; i++) {
            pali = pali && s.charAt(i)==s.charAt(s.length()-i-1);
        }
        return pali;
    } // isPalindrome


    /*
    Write a method named indexOf that returns the index of a particular value in an
    array of integers. The method should return the index of the first occurrence of
    the target value in the array. If the value is not in the array, it should
    return -1. For example, if an array called list stores the following values:

    int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0};

    Then the call indexOf(list, 8) should return 4 because the index of the first
    occurrence of value 8 in the array is at index 4. The call indexOf(list, 2)
    should return -1 because value 2 is not in the array.
     */
    static int indexOf(int[] a, int value) {
        int result = -1;
        int i = 0;
        while (i < a.length && result == -1) {
            result = (a[i]==value) ? i : result;
            i++;
        }
        return result;
    } // indexOf


    /* The solution for problem "Student" can be found in file
       Student.java
       in the same folder as this file */


    /*
    Write a console program in a class named FizzBuzz that prompts the user for an
    integer, then prints all of the numbers from one to that integer, separated by
    spaces. Use a loop to print the numbers. But for multiples of three, print "Fizz"
    instead of the number, and for the multiples of five print "Buzz". For numbers
    which are multiples of both three and five print "FizzBuzz". Drop to a new line
    after printing each 20 numbers.
     */
    static void FizzBuzz(int fizzFactor, int buzzFactor, int newLineAfter) {

        int FIZZBUZZ_FACTOR = fizzFactor * buzzFactor;

        Scanner s = new Scanner(System.in);
        System.out.print("Max value? ");
        int n = s.nextInt();

        for (int i = 1; i <=n; i++) {

            if (i%FIZZBUZZ_FACTOR == 0) {
                System.out.print("FizzBuzz ");
            } else if (i%fizzFactor == 0) {
                System.out.print("Fizz ");
            } else if (i%buzzFactor == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }

            if (i%newLineAfter == 0)
                System.out.print("\n");

        }
    } // FizzBuzz


    /*
    Write a method named secondIndexOf that returns the index of the second occurrence
    of a particular value in an array of integers. If the value does not appear in
    the array at least twice, you should return -1. For example, if an array called
    list stores the following values:

            // index  0  1   2   3  4   5   6  7   8  9  10
       int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0, 42};

    Then the call secondIndexOf(list, 42) should return 6 because the index of the
    second occurrence of value 42 in the array is at index 6. The call
    secondIndexOf(list, 14) should return -1 because value 14 does not occur at
    least twice in the array.
     */
    static int secondIndexOf(int[] a, int value) {
        int result = -1;
        int index = 0;
        boolean firstFound = false;
        while (index < a.length && result == -1) {
            if (a[index] == value && !firstFound) {
                firstFound = true;
            } else if (a[index] == value && firstFound) {
                result = index;
            }
            index++;
        }
        return result;
    } // secondIndexOf


    /*
    What is wrong with the following sumTo method, which attempts to add all numbers
    from 1 to a given maximum? Correct the code so that it properly implements this behavior.
    For example the call of sumTo(5) should return 1+2+3+4+5 = 15. You may assume that the
    value passed is at least 1.
     */
    static int sumTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            //  NEEDS TO BE MOVED BEFORE THE LOOP: int sum = 0;
            sum += i;
        }
        return sum;
    } // sumTo


    /*
    Write a method named isMonotonic that accepts an array of integers as a parameter
    and returns true if the array's element values are monotonic; that is, whether the
    array is entirely in ascending or descending order. For example, if an array called
    a stores {2, 5, 7, 18} or {9, 6, 2, 2, 0, -4}, then the call of isMonotonic(a)
    should return true. If the array not in monotonic order, such as {4, 8, 7, 11, 12},
    return false. An empty, one-element, or two-element array is always considered
    to be monotonic.

    An optimal solution runs in O(N) time and uses a constant amount of extra space.
    You should not modify the contents of the array passed to your method.
     */
    static boolean isMonotonic(int[] a) {
        boolean asc = true, des = true;
        if (a.length > 1 ) {
            asc = a[0] <= a[1];
            des = a[0] >= a[1];
            for (int i = 1; i < a.length-1; i++) {
                asc = asc && (a[i] <= a[i+1]);
                des = des && (a[i] >= a[i+1]);
            }
        }
        return asc || des;
    } // isMonotonic


    /*
    Write a method named sqrt that accepts an integer N as a parameter and returns
    the square root of N as an integer. The challenge here is that you must not use
    Math.sqrt or Math.pow or other library methods to calculate the square root;
    rather, you must compute it yourself. You should return the square root as a
    truncated integer; for example, the square root of 7 is approximately 2.65,
    but your method should return 2. You may assume that the value of N passed is
    a positive integer.
     */
    static int sqrt(int n) {
        int root = 1;
        while (root*root <= n) {
            root++;
        }
        return root-1;
    } // sqrt

    /*
    Write a method named isRotation that accepts two strings as parameters and
    returns true if they are rotations of each other. Two strings are considered
    rotations if they contain the same characters in the same relative order when
    wrapped around. For example, the call of isRotation("abcde", "deabc") should
    return true. The call of isRotation("abcde", "edcba") should return false
    because the characters are not in the same order. A string is also considered
    to be its own rotation.
     */
    static boolean isRotation(String a, String b) {
        boolean result = a.equals(b);
        if ((!result) && a.length()==b.length()) {
            int aIndex = 0;
            char aLetter = a.charAt(aIndex);
            int bIndex = b.indexOf(aLetter);
            result = bIndex > -1;
            while (result && aIndex < a.length()) {
                char bLetter = b.charAt(bIndex);
                aLetter = a.charAt(aIndex);
                result = result && aLetter == bLetter;
                aIndex++;
                bIndex = (bIndex+1) % b.length();
            }
        }
        return result;
    } // isRotation


    /*
    Write a method seeMovie that indicates how interested you are in seeing a movie
    with your friends based on its price and rating. Your method should accept two
    parameters: the cost of a ticket in dollars, and the number of stars the movie
    received out of 5. The method should print console output about how interested
    you are. Print either very interested, sort-of interested, or not interested,
    based on the following criteria:

    - You like bargains. Any movie that costs less than $5.00 is one that you are
    very interested in.
    - You dislike expensive movies. You are not interested in seeing any movie that
    costs $12.00 or more, unless it got 5 stars (and even then, you are only
    sort-of interested).
    - You like quality. You are very interested in seeing 5 star movies that
    cost under $12.00.
    - You are sort-of interested in seeing movies costing between $5.00 - $11.99
    that also got between 2-4 stars inclusive.
    - You are not interested in seeing any other movies not described previously.
     */
    static void seeMovie(double cost, int stars) {
        if (cost < 5.0 || (stars >= 5 && cost < 12)) {
            System.out.println("very interested");
        } else if ( (cost >= 12.0 && stars >= 5) || ((cost >= 5.0 && cost <= 11.99) && (stars >= 2 && stars <= 4)))  {
            System.out.println("sort-of interested");
        } else {
            System.out.println("not interested");
        }
    } // seeMovie
}
