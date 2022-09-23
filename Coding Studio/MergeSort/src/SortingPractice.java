public class SortingPractice {

    /**
     * Merges two sorted arrays into one sorted array
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
     * Returns a slice of an array from position start up to, but not including
     * position end.
     *
     * @param array int array to slice
     * @param start int beginning of slice
     * @param end int end of slice
     * @return slice of array from start up to end. Method returns an array of
     * length 0 if start or end are out of bounds.
     */
    static int[] slice(int[] array, int start, int end) {
        // Initialize empty array to return if start, end out of bounds
        int[] slicedArray = {};
        // Validate start, end
        if (start >=0 && end < array.length) {
            // Initialize properly sized array to return
            slicedArray = new int[end - start];
            // Copy elements from input array into slice
            for (int i = 0; i < slicedArray.length; i++) {
                slicedArray[i] = array[start + i];
            }
        }
        return slicedArray;
    }  // method slide


    /**
     * Iterative implementation of merge sort.
     *
     * The functionality of this method is best described with the following
     * example. Consider the array input
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
     * Again, these sorted sub-arrays must be replaced into arr:
     *
     *   arr = [4,5,6,7,0,1,2,3]
     *
     * For here, we have only one pair of 4-element sorted arrays that can be
     * merged into an array with 8 elements. And we are done.
     *
     * Of course your method must work with arrays of any size -- not just 8.
     * You may assume that the size of the input array will always be a power of 2.
     *
     * @param array int array to sort
     * @return int array sorted
     */
    static int[] iterativeMergeSort(int[] array) {
        return array;
    }  // method iterativeMergeSort

}  // class SortingPractice
