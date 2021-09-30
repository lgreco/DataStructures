/**
 * A naive implementation of a mathematical set based on an array. A set observes the following
 * principles:
 *  - order in which elements appear in it, does not matter;
 *  - no duplicates are allowed
 */
public class ArrayIntegerSet {
    private int[] setElement; // array to hold elements of our set
    private int size; // how many elements in the set?
    public ArrayIntegerSet() { // default constructor
        setElement = new int[10];
        size = 0;
    }

    /** Simple method to check is a value is already a set element */
    public boolean contains(int value) {
        boolean found = false; // assume value is not in the set
        /*
        lab assignment 1: convert this to a while loop for more efficient performance
         */
        for ( int i = 0; i < size; i++ ) {
            if ( setElement[i] == value ) { found = true; }
        }
        return found;
    } // method contains

    /** Method to add a value in the set */
    public boolean add(int value) {
        boolean success = false; // assume insertion failS
        if (!contains(value)) {
            if (size < setElement.length) {
                setElement[size] = value;
                size++;
                success = true;
            }
        }
        return success;
    } // method add

    /** Method to remove element */
    public boolean remove(int value) {
        boolean success = false; // assume removal fails
        if (contains(value)) { // element is present and can be removed
            // but how to remove it efficiently?
            // After removing it:
            //                     adjust size to reflect one less element;
            //                     change success = true
        }
        return success;
    } // method remove

    // Driver
    public static void main(String[] args) {
        ArrayIntegerSet mySet = new ArrayIntegerSet();
        mySet.add(1);
        mySet.add(3);
        mySet.add(7);
        mySet.add(9);
        mySet.displaySet();
    } // method main

    /** Display the set */
    public void displaySet() {
        System.out.printf("\n\nYour set:\n\t{");
        for ( int i = 0; i < size-1; i++ ) {
            System.out.printf("%d, ", setElement[i]);
        }
        System.out.printf("%d}\n\n", setElement[size-1]);
    } // method displaySet
}
