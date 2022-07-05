public class LengthLess {

    /**
     * Finds the size of an array without using its length variable.
     *
     * @param array to evaluate
     * @return size of the array
     */
    public static int arraySize(String[] array) {
        // Assume array is empty
        int len = 0;
        // Controller for the while loop
        boolean thereAreElements = true;
        /*
        If array position [len] is out of bounds, an exception will stop the loop,
        otherwise, len will increment by one and repeat the loop.
         */
        while (thereAreElements) {
            try {
                if (array[len] == null || array[len] != null)
                    len++;
            } catch (Exception e) {
                thereAreElements = false;
            }
        }
        return len;
    }  // method arraySize


    /** Driver code to test your method ** Do not edit below this line ** Updated 01JUL22 **/
    public static void main(String[] args) {
        String[] test1 = {};
        String[] test2 = {"a"};
        String[] test3 = {"a", "b", "c", "d"};
        String[] test4 = new String[5];

        // It's ok to use .length for testing
        boolean pass1 = (arraySize(test1) == test1.length);
        boolean pass2 = (arraySize(test2) == test2.length);
        boolean pass3 = (arraySize(test3) == test3.length);
        boolean pass4 = (arraySize(test4) == test4.length);

        if (pass1 && pass2 && pass3 && pass4)
            System.out.println("\n\nYour code passes all four tests.\n");
        else
            System.out.println("\n\nYour code failed at least one test.\n");
    }
}
