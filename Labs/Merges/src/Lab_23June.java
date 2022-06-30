import java.util.Arrays;

public class Lab_23June {

    /**
     * Merges two arrays, already sorted in ascending order, to an array that is
     * also in ascending order, and returns the merged array.
     *
     * The merged array is populated from left to right by comparing the leftmost
     * elements of the input arrays and selected the one with the smallest value.
     * If all the elements from an input array have been used, the remaining
     * elements of the second array are copied to the merged array without any
     * further comparisons.
     *
     * @param a input array in ascending order
     * @param b input array in ascending order
     * @return int[] with all elements from input arrays, in ascending order.
     */
    public static int[] merge(int[] a, int[] b) {
        // Initialize array to return; its length equals the total length of input arrays.
        int[] merged = new int[a.length+b.length];
        // Merge only sorted arrays
        if (verifySorting(a) == 1 && verifySorting(b) == 1) {
            // Setup cursors to track the leftmost elements for a, b:
            int aCursor = 0, bCursor = 0;
            // Populate merged array from left ([0]) to right ([merged.length-1])
            for (int i = 0; i < merged.length; i++) {
            /*
            For every position [i] in the merged array, check to see if
            either of the inputs a[] or b[] have any remaining elements
            to process. If one of them is out of elements, copy the
            remaining elements of the other input array into the merged
            array directly. But if both a[] and b[] have unprocessed elements,
            compare their leftmost ones, find the smallest, and place it at
            the i-th position in the merged array.
             */
                if (aCursor == a.length) {
                    // array a is fully processed, just copy the remaining of b[] to merged[]
                    merged[i] = b[bCursor];
                    // Move leftmost cursor to the next element.
                    bCursor++;
                } else if (bCursor == b.length) {
                    // array b is fully processed, just copy the remaining of a[] to merged[]
                    merged[i] = a[aCursor];
                    // Move leftmost cursor to the next element.
                    aCursor++;
                } else {
                    // Both a, b have elements to process, so compare their leftmost elements:
                    if (a[aCursor] < b[bCursor]) {
                        // between a and b, smallest element in in a
                        merged[i] = a[aCursor];
                        // Move leftmost cursor to the next element.
                        aCursor++;
                    } else {
                        // Smallest element is in b
                        merged[i] = b[bCursor];
                        // Move leftmost cursor to the next element.
                        bCursor++;
                    }
                }
            }
        }
        return merged;
    }  // method merge


    /**
     * Assesses the sorted status of an array.
     *
     * @param array int[] to evaluate
     * @return  -1 if array is sorted in descending order;
     *           0 if array is not sorted;
     *           1 if array is sorted in ascending order;
     */
    public static int verifySorting(int[] array) {
        boolean asc = true, desc = true;
        for (int i = 0; i < array.length-1; i++) {
            asc = asc && (array[i] <= array[i+1]);
            desc = desc && (array[i] >= array[i+1]);
        }
        return (!asc && !desc) ? 0 : (asc) ? 1 : -1;
    }  // method verifySorting


    public static void main(String[] args) {
        int[] testA = {2, 22, 222, 2222};
        int[] testB = {1,  3,   4, 3333};
        int[] merged = merge(testA, testB);
        System.out.println(Arrays.toString(merged));
    }


} 