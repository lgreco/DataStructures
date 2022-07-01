public class LengthLess {

    /***************   W R I T E   Y O U R   C O D E   H E R E    ***************/



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
