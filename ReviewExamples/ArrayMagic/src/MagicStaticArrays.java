/**
 * A class with some ... interesting techniques
 */
public class MagicStaticArrays {

    /**
     * Principal method to resize an array to a given size.
     * @param inputArray Array to resize
     * @param numberOfAdditionalElements Size to resize to
     * @return Resized array
     */
    private static String[] resize(String[] inputArray, int numberOfAdditionalElements) {
        String temporary[] = new String[numberOfAdditionalElements];
        for (int i = 0; i < inputArray.length; i++) {
            temporary[i] = inputArray[i];
        }
        return temporary;
    }

    /**
     * Helper method to resize to twice existing size
     * @param inputArray Array to resize
     * @return Array with 2X elements
     */
    public static String[] resize(String[] inputArray) {
        return resize(inputArray, 2*inputArray.length);
    }

    /**
     * Helper method to resize array to current size + specific number of eleemnts
     * @param additionalElements How many elements to add?
     * @param inputArray Array to resize
     * @return Resized array with additional elements.
     */
     public static String[] resize(int additionalElements, String[] inputArray) {
        return resize(inputArray,inputArray.length+additionalElements);
    }



    public static void main(String[] args) {
        String myImaginaryFriends[] = new String[3];
        myImaginaryFriends[0] = "Frodo";
        myImaginaryFriends[1] = "Sam";
        myImaginaryFriends[2] = "Sauron";

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);

        /*
        String temporary[] = new String[myImaginaryFriends.length*3];
        for (int i = 0; i < myImaginaryFriends.length; i++) {
            temporary[i] = myImaginaryFriends[i];
        }
        myImaginaryFriends = temporary;
         */

        myImaginaryFriends = resize(myImaginaryFriends);

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);


        myImaginaryFriends[3] = "Gimli";
        myImaginaryFriends[4] = "Tom";
        myImaginaryFriends[5] = "Pipin";

        myImaginaryFriends = resize(myImaginaryFriends);

        System.out.printf("\n\nThere are %d elements in your array", myImaginaryFriends.length);


        myImaginaryFriends[6] = "Gandalf";

    }
}
