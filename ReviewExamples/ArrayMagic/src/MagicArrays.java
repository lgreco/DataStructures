public class MagicArrays {

    /** The main field of the class, the underlying array we call "a" **/
    private String[] a = new String[0];
    /** How many elements are occupied **/
    private int size = 0;
    /** The last and currently occupied position */
    private int lastPosition = -1;
    /** Print this number of elements per line */
    private final static int ITEMS_PER_LINE = 5; // FINAL VARIABLES IN UPPER CASE

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
        }
        size++; // increase size
    } // method addElement

    /**
     * Adds a new element after given position and moves everything downstream
     * one position to the right. The new element is added to the right of the
     * specified position.
     *
     * @param s String to add
     * @param position position to add the element next to
     */
    public void addElement(String s, int position) {
        // Make sure requested position is valid number
        if (position > -1 && position < a.length) {
            // Set up temporary array with room for one more element
            String[] temporary = new String[a.length+1];
            // everyone before the new addition maintains position
            for (int i = 0; i <= position; i++) {
                temporary[i] = a[i];
            }
            // place the new addition at location position + 1
            temporary[position+1] = s;
            // everyone after the new addititon moves one position the right
            for (int i = position+1; i < a.length ; i++) {
                temporary[i+1] = a[i];
            }
            size++; // Update size to reflect new element
            a = temporary; // copy temporary back to array a[]
        }
    } // method addElement

    /** Prints a nicely formatted rendering of the array */
    public void printMagicArray() {
        // Is there anything to print here?
        if (a.length==0) {
            System.out.printf("\n\nNothing to print!\n");
        } else {
            System.out.printf("\n\nYour array has the following %d elements:\n\n\t{ %s", size,a[0]);
            if (a.length>1) {
                int itemCount = 1; // =1 to reflect printing of a[0]
                System.out.printf(", ");
                /*
                The following loop may contain a logical inconsistency.
                We run the loop to the full length of a[]. However, we
                have not established for sure that every element of the
                array is used. In other words, we do not have a guarantee
                that size = a.length. But we assume so, and that may be
                risky. Still, ok to use for now.

                The loop prints from the second element ([1]) all the way
                to the element before last, i.e., [a.length-2], using
                commas after each item. The last item is printed after the
                loop without separating comma.
                 */
                for (int i = 1; i < a.length-1; i++) {
                    // We print a fixed number of items per line, them move to next line
                    if (itemCount > ITEMS_PER_LINE) {
                        itemCount = 0; // reset counter
                        System.out.printf("\n\t  "); // new line and spacing
                    }
                    System.out.printf("%s, ",a[i]);
                    itemCount++;
                }
                // And finally print the last element of the array
                System.out.printf("%s",a[a.length-1]);
            } // if length>1
            System.out.printf(" }\n");
        } // if length==0
    } // method printMagicArray

    /** Driver method */
    public static void main(String[] args) {
        // Instantiate MagicArrays object
        MagicArrays magic = new MagicArrays();
        // Populate the object
        magic.addElement("Frodo"); magic.addElement("Sam"); magic.addElement("Galadriel");
        magic.addElement("Gimli"); magic.addElement("Eowyn"); magic.addElement("Faramir");
        magic.addElement("Boromir"); magic.addElement("Pipin"); magic.addElement("Leo");
        magic.addElement("Tom"); magic.addElement("Gandalf"); magic.addElement("Legolas");
        magic.addElement("Bilbo"); magic.addElement("Denethor"); magic.addElement("Elrond");
        magic.addElement("Saruman"); magic.addElement("Smeagol",5);
        // Display the object
        magic.printMagicArray();
    } // method main
} // class MagicArrays
