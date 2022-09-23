import java.util.Arrays;

public class SortingTools {

    /**
     * Write a method that accepts two arrays and returns
     * an array with the elements of both arrays merged in it.
     * Assume that input arrays are sorted, and ensure that
     * the output array is also sorted.
     *
     * Eg input
     *   a = [5, 10]
     *   b = [3, 7]
     *   c = [3,5,7,10]
     *
     *   Initialize c   __3__ ____ ____ ____
     *
     *   if a[0] < b[0]
     *     c[0] = a[0] -- eliminate a[0] from further consideration
     *   else
     *     c[0] = b[0] -- eliminate b[0] from further consideration
     */
    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        // Array cursors
        int cursorA = 0;
        int cursorB = 0;
        int cursorC = 0;
        // As long as both arrays have elements to consider
        while (cursorA < a.length && cursorB < b.length) {
            if (a[cursorA] < b[cursorB]) {
                c[cursorC++] = a[cursorA++];
            } else {
                c[cursorC++] = b[cursorB++];
            }
            // cursorC++;
        }
        // In case array a still has elements
        while (cursorA < a.length) {
            c[cursorC++] = a[cursorA++];
        }
        // In case array b still has elements
        while (cursorB < b.length) {
            c[cursorC++] = b[cursorB++];
        }
        return c;
    }

    public static void main(String[] args) {
        int[] foo = {11};
        int[] bar = {6};
        int[] test = merge(foo, bar);
        System.out.println(Arrays.toString(test));
    }
}
