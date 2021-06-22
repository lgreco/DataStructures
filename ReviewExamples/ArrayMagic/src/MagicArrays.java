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

    /** Prints a nicely formatted rendering of the array */
    public void printMagicArray() {

        if (a.length==0) {
            System.out.printf("\n\nNothing to print!\n");
        } else {
            System.out.printf("\n\nYour array data:\n\t{ %s", a[0]);
            if (a.length==1) {
                System.out.printf(" }\n");
            } else {
                int itemCount = 1;
                System.out.printf(", ");
                for (int i = 1; i < a.length-1; i++) {
                    if (itemCount > 4 ) { // magic number -- remove it!
                        itemCount = 0;
                        System.out.printf("\n\t  ");
                    }
                    System.out.printf("%s, ",a[i]);
                    itemCount++;
                }
                System.out.printf("%s",a[a.length-1]);
                System.out.printf(" }\n");
            }
        }


    } // method printMagicArray



    public static void main(String[] args) {
        MagicArrays ourFirstRealDataStructure = new MagicArrays();
        ourFirstRealDataStructure.addElement("Frodo");
        ourFirstRealDataStructure.printMagicArray();

        ourFirstRealDataStructure.addElement("Sam");
        ourFirstRealDataStructure.addElement("Galadriel");
        ourFirstRealDataStructure.addElement("Gimli");
        ourFirstRealDataStructure.addElement("Eowen");
        ourFirstRealDataStructure.addElement("Faramir");
        ourFirstRealDataStructure.addElement("Boromir");
        ourFirstRealDataStructure.addElement("Pipin");
        ourFirstRealDataStructure.addElement("Leo");
        ourFirstRealDataStructure.addElement("Tom");
        ourFirstRealDataStructure.addElement("Gandalf");

        ourFirstRealDataStructure.addElement("Legolas");
        ourFirstRealDataStructure.addElement("Bilbo");
        ourFirstRealDataStructure.addElement("Denethor");
        ourFirstRealDataStructure.addElement("Elrond");
        ourFirstRealDataStructure.addElement("Saruman");
        ourFirstRealDataStructure.printMagicArray();
    }

}
