/**
 * A class with a static method to increase, on demand, the length of
 * a String array
 */
public class MagicStaticArrays {

    /**
     * Principal method to makeLonger an array to a given size. The method checks to
     * ensure that the proposed new size is greater than the current length of
     * the array -- there is no point making the array smaller, is there? If the
     * requested new size is not larger, then the method automatically adds just
     * one more element to the array.
     *
     * @param arrayToResize Array to lengthen
     * @param newLength New length to makeLonger to
     * @return Longer array
     */
    private static String[] makeLonger(String[] arrayToResize, int newLength) {
        /*
         If newLength is not greater than the current length of the array,
         make sure it is, even by one element.
         */
        if (newLength <= arrayToResize.length) {
            newLength = arrayToResize.length + 1; /
        }
        // At this point newLength > .length
        String longer[] = new String[newLength];
        // Copy array to be resized into longer array
        for (int i = 0; i < arrayToResize.length; i++) {
            longer[i] = arrayToResize[i];
        }
        return longer;
    }

    /**
     * Helper method, resizes automatically to twice current length
     * @param arrayToMakeLonger Array to makeLonger
     * @return Longer array with 2X elements
     */
    public static String[] makeLonger(String[] arrayToMakeLonger) {
        return makeLonger(arrayToMakeLonger, 2*arrayToMakeLonger.length);
    }

    /**
     * Helper method to makeLonger array to current size + specific number of elements
     *
     * @param additionalElements How many elements to add?
     * @param arrayToMakeLonger Array to makeLonger
     * @return Longer array with additional elements.
     */
     public static String[] makeLonger(int additionalElements, String[] arrayToMakeLonger) {
        return makeLonger(arrayToMakeLonger,arrayToMakeLonger.length+additionalElements);
    }

    /** Driver method (aka main) **/
    public static void main(String[] args) {
        String myImaginaryFriends[] = new String[3];
        myImaginaryFriends[0] = "Frodo";
        myImaginaryFriends[1] = "Sam";
        myImaginaryFriends[2] = "Sauron";

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);

        myImaginaryFriends = makeLonger(myImaginaryFriends);

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);


        myImaginaryFriends[3] = "Gimli";
        myImaginaryFriends[4] = "Tom";
        myImaginaryFriends[5] = "Pipin";

        myImaginaryFriends = makeLonger(myImaginaryFriends);

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);

        myImaginaryFriends[6] = "Gandalf";

    }
}
