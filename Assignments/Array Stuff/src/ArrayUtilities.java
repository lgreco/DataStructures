import java.util.Arrays;

public class ArrayUtilities {

    /**
     * Removes duplicates from an int array and returns an array with the
     * unique elements only.
     *
     * The method begins traversing the input array from the beginning. It
     * assumes that the first element it encounters is unique and adds it to
     * a temporary array. Then it checks the subsequent elements, skipping them
     * if they are the same as the element it just added to the temporary
     * array. When it encounters a new (different) element, it advances the
     * traversal cursor that the position, and repeats.
     *
     * The method also keeps count of how many unique elements were found.
     * The count is used as an index for the temporary array -- where to place
     * the next unique element -- and also to size the output array to exactly
     * the final number of unique elements.
     *
     * @param a int[] to remove duplicates from
     *
     * @return array with the unique elements of a.
     */
    public static int[] removeDuplicates(int[] a) {
        // Initialize the return array, as a copy of a. This may change if
        // input array has more than one elements.
        int[] returnArray = a;
        // An array with 0 or 1 element contains no duplicates. Process only
        // arrays with 2 or more elements.
        if (a.length > 1) {
            // Create a temp array to hold the unique values; it should be as
            // large as the input array, in case there are no duplicates.
            int[] temporary = new int[a.length];
            // Unique element counter is necessary to know where to place the
            // next such element in temporary array.
            int uniqueElements = 0;
            // Traverse the input array
            int inputIndex = 0;
            while (inputIndex < a.length) {
                // Copy current element to temporary array as it is unique
                temporary[uniqueElements] = a[inputIndex];
                // Increment uniqueElements to know where to place next such
                // element
                uniqueElements++;
                // If not at the end of the input array, check the elements
                // ahead of inputIndex for duplicates and skip them
                if (inputIndex < a.length - 1) {
                    // Start with position next to the current position
                    int j = inputIndex + 1;
                    while (j < a.length && a[inputIndex] == a[j]) {
                        // if element is the same, move to the next one.
                        j++;
                    }
                    /*
                    Advance the input index to the next non-duplicate element,
                    skipping any duplicate elements we found. Subtract 1 to
                    compensate for the j++).
                     */
                    inputIndex = j - 1;
                }
                // Continue scanning the array from this position.
                inputIndex++;
            }
            // Resize the return array and copy the elements of temp array
            // to it.
            returnArray = new int[uniqueElements];
            for (int i = 0; i < uniqueElements; i++) {
                returnArray[i] = temporary[i];
            }
        }
        return returnArray;
    }  // method removeDuplicates


    /** Simple test code for removeDuplicates @version 202207261000
     *
     * DO NOT MODIFY THE CODE IN METHOD main
     *
     */
    public static void main(String[] args) {
        int[] test = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7};
        int[] result = removeDuplicates(test);
        boolean success = true;
        for (int i = 0; i < result.length ; i++) {
            success = success && (result[i] == i);
        }
        if (success)
            System.out.println("\n\nYour method seems to be working as expected\n\n");
        else
            System.out.println("\n\nYour method is not working as specified.\n\n");
    }
}
