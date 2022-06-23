import java.util.ArrayList;
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
        // Setup leftmost points for a, b:
        int aCursor = 0, bCursor = 0;
        // Populate merged array from left ([0]) to right ([merged.length-1])
        for (int i = 0; i < merged.length; i++) {
            if (aCursor == a.length) {
                // array a is fully processed, just copy the remaining of b to merged[]
                merged[i] = b[bCursor];
                bCursor++;
            } else if (bCursor == b.length) {
                // array b is fully processed, just copy the remaining of a to merged[]
                merged[i] = a[aCursor];
                aCursor++;
            } else {
                // Both a, b have elements to process, so compare their leftmost elements:
                if (a[aCursor] < b[bCursor]) {
                    merged[i] = a[aCursor];
                    aCursor++;
                } else {
                    merged[i] = b[bCursor];
                    bCursor++;
                }
            }
        }
        return merged;
    }  // method merge

    public static void main(String[] args) {

    }
    
    
} 