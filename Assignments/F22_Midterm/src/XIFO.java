import java.util.Arrays;
import java.util.Random;

/**
 * An array-based demonstration for FIFO and LIFO operations
 *
 */

public class XIFO implements LIFO, FIFO {

    /**
     * An array that stores strings added to it either on a first-available
     * basis (using the addLast method); or inserted as the first element
     * (using the addFirst method).
     */
    private String[] xifo;


    /** A counter that tells us when the xifo array is full or empty */
    private int usage;


    /** Default size for the array if someone calls the default constructor */
    private static final int DEFAULT_SIZE = 4;


    /**
     * Default constructor. Passes the default size value to the basic constructor.
     *
     * DO NOT MODIFY THIS CONSTRUCTOR
     */
    public XIFO() {
        this(DEFAULT_SIZE);
    }  // Default constructor ... DO NOT MODIFY


    /**
     * Basic constructor. Initializes an array with the specified size and sets
     * its usage to 0.
     *
     * @param size int value of size for the xifo array.
     *
     * DO NOT MODIFY THIS CONSTRUCTOR
     */
    public XIFO(int size) {
        this.xifo = new String[size];
        this.usage = 0;
    }  // Basic constructor ... DO NOT MODIFY


    /**
     * Last-in.
     *
     * Method adds a string to the first available position in the array, if there
     * is room in the array. Note that the method does not add elements at the
     * last position in the array but at the first available. As more elements
     * are added, they move closer and closer to the end fo the array.
     *
     * @param string String value to the end of the array
     *
     * DO NOT MODIFY THIS METHOD
     */
    public void addLast(String string) {
        // Check that there is room in the array
        if (this.usage < this.xifo.length) {
            this.xifo[usage] = string;
            // Update usage
            this.usage++;
        }
    }  // method addLast ... DO NOT MODIFY


    /**
     * First out.
     *
     * Method removes the first element of the array.
     *
     * @return String with the value of the first element in the array.
     */
    public String removeFirst() {
        String removed = null;
        /*
        COMPLETE THIS METHOD
         */
        if (this.usage > 0) {
            // write some awesome code here, and then ...
            this.usage--;
        }
        return removed;
    }  // method removeFirst


    /**
     * First in
     *
     * Adds an element at the beginning of the array, if there is room in the
     * array. The method must ensure that existing elements in the array are not
     * lost. For example, consider the array ["C", "B", "A", null]. If we use
     * addFirst("D"), the array must become ["D", "C", "B", "A"].
     *
     * @param string String value to add to the beginning of the array.
     */
    public void addFirst(String string) {
        /*
        COMPLETE THIS METHOD
         */
    }  // method addFirst


    /** FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD */
    public String[] getXifo() {
        return this.xifo;
    }  // method getXifo ... DO NOT MODIFY


    /** FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD */
    public String toString() {
        return Arrays.toString(this.xifo);
    }  // method toString ... DO NOT MODIFY

}
