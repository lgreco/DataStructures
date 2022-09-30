import java.util.Random;

public class Solution_SortingPractice {

    /**
     * Iterative, in-place-ish merge sort.
     *
     * @param array int[] to sort
     */
    static void iterativeMergeSort(int[] array) {
        // Start with single-element arrays and keep doubling the size.
        for (int size = 1; size <= array.length/2; size = size*2) {
            // The next loop identifies the pairs of the subarrays we need to partition.
            // Notice the loop's increment expression!
            for (int i = 0; i < array.length; i=i+2*size) {
                // First array of the pair
                int[] foo = slice(array,i,i+size);
                // Second array of the pair
                int[] bar = slice(array,i+size,i+2*size);
                // Merging the pair
                int[] temp = merge(foo,bar);
                // Copy merged array to locations its pair came from
                for (int j = 0; j < temp.length; j++) {
                    array[j+i] = temp[j];
                }
            }
        }
    }  // method iterativeMergeSort


    /**
     * Merges two sorted (in ascending order) arrays into a sorted array, also
     * in ascending order.
     *
     * Method assumes (but does not verify) that input arrays are sorted. This
     * is a more compact version of the typical merge technique, taking advantage
     * of self-incrementing array cursors.
     *
     * @param a int[] one of the two sorted arrays to merge
     * @param b int[] the second of the two sorted arrays to merge
     * @return int[] sorted array merging the two input arrays
     */
    static int[] merge(int[] a, int[] b) {
        // Initialize the output array
        int[] merged = new int[a.length+b.length];
        // Cursors for the output and input arrays all set at their beginnings.
        int mergedIndex =  0;
        int aLeftMost = 0;
        int bLeftMost = 0;
        // Loop to process elements from both input arrays
        while(aLeftMost < a.length && bLeftMost < b.length) {
            if (a[aLeftMost] < b[bLeftMost]) {
                merged[mergedIndex++] = a[aLeftMost++];
            } else {
                merged[mergedIndex++] = b[bLeftMost++];
            }
        }
        // Loop to process only array a when array b has been exhausted
        while (aLeftMost < a.length) {
            merged[mergedIndex++] = a[aLeftMost++];
        }
        // Loop to process only array b when array a has been exhausted
        while (bLeftMost < b.length) {
            merged[mergedIndex++] = b[bLeftMost++];
        }
        return merged;
    }  // method merge2


    /**
     * Returns a slice of an array from position start upto, but not including,
     * position end.
     *
     * @param array int array to slice
     * @param start int beginning of slice
     * @param end int end of slice
     * @return int array with slice of array from start upto end. If parameters
     * start or end are out of bounds, method returns an array of length 0.
     */
    static int[] slice(int[] array, int start, int end) {
        // Initialize empty array to return if start or end are out of bounds
        int[] slicedArray = {};
        // Validate start, end
        if (start >=0 && end <= array.length) {
            // Initialize properly sized array to return
            slicedArray = new int[end - start];
            // Copy elements from input array into slice
            for (int i = 0; i < slicedArray.length; i++) {
                slicedArray[i] = array[start + i];
            }
        }
        return slicedArray;
    }  // method slice


    /** Simple testing code */
    public static void test() {
        // To generate random sized arrays with random values
        Random random = new Random();
        // Presume all will end well
        boolean testOutcome = true;
        // Set the max power of 2 for array size (anything over 2^20 too slow)
        final int MAX_POWER_2 = 12;
        // Range of values in the array is 0 through MAX_ARRAY_VALUE
        final int MAX_ARRAY_VALUE = 100;
        // How many tests to perform?
        final int TESTS = 1000;
        // Header
        System.out.printf("\n\nTesting iterativeMergeSort:\n");
        // Test counter
        int test = 0;
        // Loop to perform the tests; ends with first failed test or when all
        // tests have run successfully.
        while (test < TESTS && testOutcome) {
            // Determine array size, as a power of 2, for this test
            int arraySize = (int) Math.pow(2.0, (double) random.nextInt(MAX_POWER_2));
            // Initialize the array
            int[] testArray = new int[arraySize];
            // Populate the array with random integers
            for (int i = 0; i < arraySize; i++) {
                testArray[i] = random.nextInt(MAX_ARRAY_VALUE);
            }
            // Pass the array to the iterativeMergeSort method
            iterativeMergeSort(testArray);
            // Test the array after merge sort to verify it is sorted; all it
            // takes is one bad result to turn outcome to false.
            testOutcome = testOutcome && isSorted(testArray);
            // Local report
            System.out.printf("\n\tTest # %04d for array with %6d elements: %s",
                    test, arraySize, (testOutcome)?"PASS":"FAIL");
            // Move to the next test
            test++;
        }
        // Report results
        if (testOutcome) {
            System.out.printf("\n\nYour method iterativeMergeSort passed all %d tests.\n", TESTS);
        } else {
            System.out.printf("\n\nYour method iterativeMergeSort failed some or all of %d tests.\n", TESTS);
        }
    }  // method test


    /**
     * Tells if an array is sorted
     * @param array int[] array to evaluate
     * @return true if in ascending or descending order
     */
    public static boolean isSorted(int[] array) {
        // Assume array is will be sorted, one way or another
        boolean asc = true;
        boolean des = true;
        int i = 0;
        // Run a loop to check that every pair of values is properly sorted.
        // Loop ends when no sorting is detected or when all elements tested.
        while ((asc || des) && i < array.length-1) {
            // Array is in ascending order as long as the next element is greater
            // than or equal to the previous. One bad pair is enough to spoil
            // the boolean and set it to false for the rest of the loop.
            asc = asc && array[i] <= array[i+1];
            // Array is in descending order as long as the next element is less
            // than or equal to the previous. One bad pair is enough to spoil
            // the boolean and set it to false for the rest of the loop.
            des = des && array[i] >= array[i+1];
            // Move to the next pair of values
            i++;
        }
        // An array is sorted if it is in ascending or descending order. When
        // both booleans are true, the array is trivially sorted, ie, all its
        // elements are equal.
        return asc || des;
    }  // method isSorted


    /** Driver code */
    public static void main(String[] args) {
        test();
    }  // method main

}  // class Solution_SortingPractice
