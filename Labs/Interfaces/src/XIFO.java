/**
 * A basic class for FIFO and LIFO operations
 */

public class XIFO {

    /** Default array size */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array of the class */
    private String[] values;

    /** How many elements are occupied? */
    private int usage;


    /** Basic constructor */
    public XIFO(int size) {
        this.values = new String[size];
        this.usage = 0;
    }


    /** Default constructor */
    public XIFO() {
        this(DEFAULT_SIZE);
    }


    /**
     * Returns the fraction of used elements over total elements in the array
     * @return a value between 0.0 and 1.0 indicating utilization of array elements.
     */
    public float utilization() {
        return ((float) this.usage)/((float) this.values.length);
    }  // method utilization


    /**
     * Method to remove and return the first element of array values.
     */
    public String remove() {
        String removed = null;
        // Operate on non-empty lists.
        if (this.usage > 0) {
            // Array is not empty
            removed = this.values[0];
            // DUE THU 7/14:
            // write a loop to move remaining elements one position to the left,
            // and null at the end.
        }
        return removed;
    }  // method remove


    /**
     * Adds an element at the *first available* position of array values.
     * Method checks to ensure that there is room for the new element.
     *
     * @param string to add to the array
     */
    public void add(String string) {
        if (this.usage < this.values.length)
            // There is room: add the element and increment usage
           this.values[this.usage++] = string;
    }  // method add


    /**
     * Adds an element at the first position (`[0]`) of array values.
     * Method checks to ensure that there is room for the new element.
     *
     * @param String to add to the array.
     */
    public void firstElement(String string) {
        if (this.usage < this.values.length) {
            // There is room to add the new string
            // DUE THU 7/14: First, move everything one position to the right
            // Second:
            this.values[0] = string;
        }
    }
}
