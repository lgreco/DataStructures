public class MagicArrays {

    /** The main field of the class, is a string array we call "a" **/
    private String[] a = new String[0];
    /** How many elements are occupied **/
    private int size = 0;
    /** The last and currently occupied position */
    private int lastPosition = -1;

    /**
     * Method to add an element the array, increasing length (and size) by 1
     *
     * @param s new element added
     */
    public void addElement(String s) {
        // Is there room in the array?
        if (size < a.length) {
            // yes there is room
            lastPosition++; // update last position
            a[lastPosition] = s;
            size++; // increase size
        } else {
            // nope ... expand the array, then add the element
            String[] temporary = new String[a.length+1]; // expand by 1
            /* Copy array to temporary */
            for (int i = 0; i < a.length; i++) {
                temporary[i] = a[i];
            }
            a = temporary; // put existing data to newly lengthened array
            /* Go to a's last element and populate it */
            lastPosition = a.length-1; // update last position
            a[lastPosition] = s; // add new element at the end of array
            size++; // increase size
        } // method addElement
    }

    public void printMagicArray() {
        System.out.println("\n\nHere're the data");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("\n\t%s",a[i]);
        }
    }



    public static void main(String[] args) {
        MagicArrays ourFirstRealDataStructure = new MagicArrays();
        ourFirstRealDataStructure.addElement("Frodo");
        ourFirstRealDataStructure.printMagicArray();

        ourFirstRealDataStructure.addElement("Sam");
        ourFirstRealDataStructure.printMagicArray();
    }

}
