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
            // Move everything one position to the left   //  * This block of code was part of the
            for (int i = 0; i < this.usage - 1; i++) {    //  * assignment that was due 7/14. It is
                this.values[i] = this.values[i+1];        //  * also the cause that removals from
            }                                             //  * an array-based queue take as many
            // Mark last occupied position as null        //  * steps as the number of items presently
            this.values[this.usage-1] = null;             //  * stored in the queue. Speeding up
            // Decrease usage                             //  * removals is the topic of the next
            usage--;                                      //  * assignment, due 7/18/22
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
        if (this.usage < this.values.length) {
            // There is room: add the element and increment usage
            this.values[this.usage] = string;
            this.usage++;
        }
    }  // method add


    /**
     * Adds an element at the first position (`[0]`) of array values.
     * Method checks to ensure that there is room for the new element.
     *
     * @param string to add to the array.
     */
    public void firstElement(String string) {
        // Operate only if there is room in the array
        if (this.usage < this.values.length) {                            //  * This block
            // Move everything one position to the right                  //  * of code was
            for (int i = 0; i < this.usage; i++) {                        //  * part of the
                this.values[this.usage-i] = this.values[this.usage-1-i];  //  * assignment that
            }                                                             //  * was due 7/14.
            // Write the new value at [0]
            this.values[0] = string;
            // Increment usage
            this.usage++;
        }
    }  // method firstElement
}
