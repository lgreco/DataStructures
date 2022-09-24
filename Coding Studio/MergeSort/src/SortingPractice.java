import java.util.Random;

/**
 * Class to showcase iterative merge sort
 * @version 20220923.1800
 */
public class SortingPractice {

    /**
     * Merges two sorted arrays into one sorted array.
     *
     * DO NOT MODIFY THIS METHOD WITHOUT DISCUSSING IT WITH LEO FIRST.
     *
     * @param first int array to merge
     * @param second int array to merge
     * @return int array with merged first and second arrays, sorted
     */
    static int[] merge(int[] first, int[] second) {
        // Initialize the output array
        int[] merged = new int[first.length+second.length];
        // Initialize array indices; use first letter of array's name
        int f = 0;
        int s = 0;
        int m = 0;
        // While both arrays have elements to process
        while (f < first.length && s < second.length) {
            if (first[f] < second[s]) {
                // Smallest value is in first array
                merged[m++] = first[f++];
            } else {
                // Smallest value is in second array
                merged[m++] = second[s++];
            }
        }
        // Second array has no more elements to process. Focus on first
        while (f < first.length) {
            merged[m++] = first[f++];
        }
        // First array has no more elements to process. Focus on second
        while (s < second.length) {
            merged[m++] = second[s++];
        }
        // Done!
        return merged;
    }  // method merge


    /**
     * Returns a slice of an array from position start upto, but not including,
     * position end.
     *
     * DO NOT MODIFY THIS METHOD WITHOUT DISCUSSING IT WITH LEO FIRST.
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


    /**
     * Iterative implementation of merge sort.
     *
     * The functionality of this method is best described with the following
     * example. Consider the array input
     *
     *   arr = [7,6,5,4,3,2,1,0]
     *
     * The first step is to merge-sort pairs of 1-element arrays and place their
     * results back into the array. The pairs of 1-element arrays to be merged
     * are:
     *
     *  pairs       merged 2-element arrays
     * [7], [6]       [6,7]    )
     * [5], [4]       [4,5]    )  These sorted sub-arrays must go back
     * [3], [2]       [2,3]    )  into proper places in the original array
     * [1], [0]       [0,1]    )
     *
     * Obtaining the partitions for the pairs above can be accomplished with
     * method slice. For example:
     *
     *   slice(arr,7,8) will return [0]
     *   slice(arr,6,7) will return [1], and so on.
     *
     * Using method slice we can pass those single-element arrays to method
     * merge, for example:
     *
     *   merge(slice(arr,0,1), slice(arr,1,2))
     *
     * will send arrays [7] and [6] into merge and the method will return
     * their merged and sorted array [6,7].
     *
     * After placing these sorted 2-element arrays back into proper positions in
     * the original array, it will look like:
     *
     *   arr = [6,7,4,5,2,3,0,1]
     *
     * Next, we need to partition arr again, into pairs of 2-element arrays:
     *
     *      pairs          merged 4-element arrays
     * [6,7] and [4,5]        [4,5,6,7]
     * [2,3] and [0,1]        [0,1,2,3]
     *
     * Method slice can produce these 2-element arrays as:
     *
     *    slice(arr,0,2) will produce [6,7]
     *    slice(arr,2,4) will produce [4,5]
     *
     * These arrays can be merged into [4,5,6,7] and these sorted sub-arrays
     * will be replaced into arr:
     *
     *   arr = [4,5,6,7,0,1,2,3]
     *
     * From here, we have only one pair of 4-element sorted arrays that can be
     * merged into an array with 8 elements. And we are done.
     *
     * Of course your method must work with arrays of any size -- not just 8.
     * You may assume that the size of the input array will always be a power of 2.
     *
     * The objective here is to partition an array first into subarrays of
     * size 1, group them into pairs, merge them into sorted arrays, copy
     * those arrays back to the input array, and repeat the process only now
     * we partition the array into subarrays of size 2. And then of size 4,
     * and so on.
     *
     * You notice that the partition size starts with 1, then it becomes 2, etc.
     * The partition size determines where to find the subarray elements. For
     * example, if
     *
     *   arr =  | 50 | 60 | 20 | 10 | 30 | 90 | 40 | 80  <-- array values
     *          0    1    2    3    4    5    6    7  <----- position index
     *
     * then we begin to observe a pattern:
     *
     *   subarray      slices for first
     *   size          pair of subarrays
     *   =========     ==================
     *   1             slice(arr,0,1);   slice(arr,1,2);
     *   2             slice(arr,0,2);   slice(arr,2,4);
     *   4             slice(arr,0,4);   slice(arr,4,8);
     *   ...           ...
     *
     *
     * @param array int array to sort
     * @return int array sorted
     */
    static int[] iterativeMergeSort(int[] array) {
        return array;
    }  // method iterativeMergeSort


    /**
     * Simple testing code.
     *
     * DO NOT MODIFY THIS METHOD WITHOUT DISCUSSING IT WITH LEO FIRST.
     *
     * */
    static void test() {
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
            System.out.printf("\n\nYour method iterativeMergeSort passed all %d tests.\n\n", TESTS);
        } else {
            System.out.printf("\n\nYour method iterativeMergeSort failed some or all of %d tests.\n\n", TESTS);
        }
    }  // method test


    /**
     * Tells if an array is sorted in ascending or descending order.
     *
     * DO NOT MODIFY THIS METHOD WITHOUT DISCUSSING IT WITH LEO FIRST.
     *
     * @param array int[] array to evaluate
     * @return true if in ascending or descending order
     */
    static boolean isSorted(int[] array) {
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


    /**
     * Driver code.
     *
     * DO NOT MODIFY THIS METHOD WITHOUT DISCUSSING IT WITH LEO FIRST.
     *
     */
    public static void main(String[] args) {
        test();
    }  // method main

}  // class SortingPractice
