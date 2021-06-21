public class MagicArrays {

    /** The main field of the class **/
    private String[] a = new String[0];
    /** How many elements are occupied **/
    private int size = 0;
    /** The last and currently occupied position */
    private int lastPosition = -1;

    public void addElement(String s) {
        // Is there room in the array?
        if (size < a.length) {
            // yes there is room
            lastPosition++;
            a[lastPosition] = s;
            size++;
        } else {
            // nope ... expand the array, then add the element
            String[] temporary = new String[a.length+1];
            for (int i = 0; i < a.length; i++) {
                temporary[i] = a[i];
            }
            a = temporary;
            /* Go to a's last element and populate it */
            lastPosition = a.length-1;
            a[lastPosition] = s;
            size++;
        }
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
