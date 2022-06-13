import java.util.Arrays;

public class ShiftArray {

    /**
     * Removes element from given position in array and shifts subsequent elements
     * one position to the left.
     *
     * @param a String array to process
     * @param position int array position to delete
     * @return processed array if position value legal, original array otherwise
     */
    public static String[] remove(String[] a, int position) {
        // Ensure that position is legal value;
        if (position > -1 && position < a.length && a.length > 0) {
            // Shift-left from deleted position onwards
            for (int i = position; i < a.length - 1; i++) {
                a[i] = a[i+1];
            }
            // Process the last element separately to avoid out of bounds errors.
            a[a.length-1] = null;
        }
        return a;
    }  // method remove


    public static void main(String[] args) {
        String[] test1 = {"A", "B", "C", "D", "E", "F"};
        String[] test2 = {};
        System.out.println(Arrays.toString(remove(test2,0)));
    }
}
